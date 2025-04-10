package cat.itb.m78.exercices.projecteAPI.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import cat.itb.m78.exercices.projecteAPI.StyledTextField
import cat.itb.m78.exercices.projecteAPI.ThreeRowCard
import cat.itb.m78.exercices.projecteAPI.TitleText
import cat.itb.m78.exercices.projecteAPI.TwoOrOneRowCard
import cat.itb.m78.exercices.projecteAPI.brush
import cat.itb.m78.exercices.projecteAPI.viewModels.ZeldaCreaturesListViewModel

@Composable
fun ZeldaCreaturesListScreen(navigateToDetailScreen: (Int) -> Unit) {
    val viewModel = viewModel { ZeldaCreaturesListViewModel() }
    val creaturesList : MutableState<List<Creature>> = viewModel.creaturesList

    ZeldaCreaturesListScreenArguments(navigateToDetailScreen, creaturesList.value)
}

@Composable
fun ZeldaCreaturesListScreenArguments(navigateToDetailScreen: (selectedCreatureName: Int) -> Unit, creaturesList: List<Creature> ) {
    var userInput by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        if (creaturesList.isEmpty()) {
            ContentLoading()
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                TitleText("Zelda creatures")

                StyledTextField(
                    onValueChange = { userInput = it },
                    value = userInput
                )

                Box(modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight()){
                    LazyColumn(state = listState, modifier = Modifier.fillMaxSize().padding(end = 16.dp)) {
                        val filteredList = creaturesList.filter { it.name.contains(userInput, ignoreCase = true) }
                        if (filteredList.isEmpty()) {
                            item {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(
                                        text = "No creatures found!",
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                }
                            }
                        }
                        val rows = filteredList.chunked(3)
                        rows.forEach { rowItems ->
                            if (rowItems.size == 3) {
                                item {
                                    ThreeRowCard(navigateToDetailScreen, rowItems)
                                }
                            } else if (rowItems.size in 1..2) {
                                item {
                                    TwoOrOneRowCard(navigateToDetailScreen, rowItems)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



