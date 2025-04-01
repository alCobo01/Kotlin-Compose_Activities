package cat.itb.m78.exercices.projecteAPI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun ZeldaCreaturesListScreen(navigateToDetailScreen: (selectedCreatureName: String) -> Unit) {
    val viewModel = viewModel { ZeldaCreaturesListViewModel() }
    val creaturesList : MutableState<List<Creature>> = viewModel.creaturesList

    ZeldaCreaturesListScreenArguments(navigateToDetailScreen, creaturesList.value)
}

@Composable
fun ZeldaCreaturesListScreenArguments(navigateToDetailScreen: (selectedCreatureName: String) -> Unit, creaturesList: List<Creature> ) {
    var userInput by remember { mutableStateOf("") }

    if (creaturesList.isEmpty()) {
        CircularProgressIndicator()
    } else {
        Column {
            TextField(
                value = userInput,
                onValueChange = {userInput = it},
                label = { Text("Search a creature!") }
            )

            LazyColumn {
                val filteredList = creaturesList.filter { it.name.contains(userInput, ignoreCase = true) }
                if (filteredList.isEmpty()) {
                    item {
                        Text("No creatures found")
                    }
                }
                filteredList.forEach {
                    item {
                        Card{
                            Button(onClick = { navigateToDetailScreen(it.name) }){
                                Text(text = it.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() })
                            }
                            AsyncImage(
                                model = it.image,
                                contentDescription = it.name
                            )
                        }
                    }
                }
            }
        }



    }
}
