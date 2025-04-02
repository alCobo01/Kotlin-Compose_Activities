package cat.itb.m78.exercices.projecteAPI.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteAPI.ContentLoading
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.ViewModels.ZeldaCreaturesListViewModel
import coil3.compose.AsyncImage

@Composable
fun ZeldaCreaturesListScreen(navigateToDetailScreen: (Int) -> Unit) {
    val viewModel = viewModel { ZeldaCreaturesListViewModel() }
    val creaturesList : MutableState<List<Creature>> = viewModel.creaturesList

    ZeldaCreaturesListScreenArguments(navigateToDetailScreen, creaturesList.value)
}

@Composable
fun ZeldaCreaturesListScreenArguments(navigateToDetailScreen: (selectedCreatureName: Int) -> Unit, creaturesList: List<Creature> ) {
    var userInput by remember { mutableStateOf("") }

    if (creaturesList.isEmpty()) {
        ContentLoading()
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
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
                        Card(
                            modifier = Modifier.padding(16.dp)
                        ){
                            Button(onClick = { navigateToDetailScreen(it.id) }){
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
