package cat.itb.m78.exercices.projecteAPI.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteAPI.ContentLoading
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.brush
import cat.itb.m78.exercices.projecteAPI.viewModels.ZeldaCreaturesListViewModel
import coil3.compose.AsyncImage
import kotlin.math.round

@Composable
fun ZeldaCreaturesListScreen(navigateToDetailScreen: (Int) -> Unit) {
    val viewModel = viewModel { ZeldaCreaturesListViewModel() }
    val creaturesList : MutableState<List<Creature>> = viewModel.creaturesList

    ZeldaCreaturesListScreenArguments(navigateToDetailScreen, creaturesList.value)
}

@Composable
fun ZeldaCreaturesListScreenArguments(navigateToDetailScreen: (selectedCreatureName: Int) -> Unit, creaturesList: List<Creature> ) {
    var userInput by remember { mutableStateOf("") }
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
                TextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                    label = { Text("Search a creature!") }
                )

                LazyColumn {
                    val filteredList = creaturesList.filter { it.name.contains(userInput, ignoreCase = true) }
                    if (filteredList.isEmpty()) {
                        item {
                            Text("No creatures found")
                        }
                    }
                    val rows = filteredList.chunked(3)
                    rows.forEach { rowItems ->
                        if (rowItems.size == 3) {
                            item {
                                Row {
                                    for (it in rowItems) {
                                        Card(
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .weight(1f),
                                            onClick = { navigateToDetailScreen(it.id) },
                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))

                                        ) {
                                            Row(
                                                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Column(
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.Center
                                                ) {
                                                    Text(text = it.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() })
                                                    Button(onClick = {}){ Icon(imageVector = Icons.Default.Favorite, contentDescription = null) }
                                                }
                                                AsyncImage(
                                                    model = it.image,
                                                    contentDescription = it.name,
                                                    modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (rowItems.size in 1..2) {
                            item {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                                ) {
                                    for (it in rowItems) {
                                        Card(
                                            modifier = Modifier.width(400.dp).height(320.dp)
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center,
                                                modifier = Modifier
                                                    .padding(16.dp)
                                                    .fillMaxSize()
                                            ) {
                                                Button(onClick = { navigateToDetailScreen(it.id) }) {
                                                    Text(
                                                        text = it.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                                                    )
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
                }
            }
        }
    }

}

