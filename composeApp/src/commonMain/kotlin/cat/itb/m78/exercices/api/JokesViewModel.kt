package cat.itb.m78.exercices.api

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.api.JokesViewModel.MyAPI.client
import cat.itb.m78.exercices.examen.CalculatorViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.random.Random

@Serializable
data class Joke(
    @SerialName("setup") val setup: String,
    @SerialName("punchline") val punchline: String
)

class JokesViewModel : ViewModel(){
    object MyAPI {
        private val url = "https://api.sampleapis.com/jokes/goodJokes"
        private val client = HttpClient() {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }

        suspend fun list() = client.get(url).body<List<Joke>>()
    }

    private var jokesList = listOf<Joke>()
    val joke: MutableState<Joke?> = mutableStateOf(null)

    fun generateJoke(){
        if (jokesList.isNotEmpty()){
            val randomJokeIndex = Random.nextInt(jokesList.size)
            joke.value = jokesList[randomJokeIndex]
        }
    }

    init {
        viewModelScope.launch(Dispatchers.Default) {
            jokesList = MyAPI.list()
            generateJoke()
        }
    }

@Composable
fun JokesScreen() {
    val viewModel: JokesViewModel = viewModel { JokesViewModel() }
    val joke = viewModel.joke.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        joke?.let { jokeData ->
            Text(text = jokeData.setup, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = jokeData.punchline, style = MaterialTheme.typography.bodyLarge)
        } ?: Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge)


        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.generateJoke() }) {
            Text(text = "New Joke")
        }
    }
    }
}