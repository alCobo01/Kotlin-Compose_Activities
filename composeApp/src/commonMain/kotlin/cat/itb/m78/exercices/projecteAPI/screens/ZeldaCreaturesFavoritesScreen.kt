package cat.itb.m78.exercices.projecteAPI.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteAPI.ContentLoading
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.ThreeRowCard
import cat.itb.m78.exercices.projecteAPI.TitleText
import cat.itb.m78.exercices.projecteAPI.TwoOrOneRowCard
import cat.itb.m78.exercices.projecteAPI.brush
import cat.itb.m78.exercices.projecteAPI.viewModels.ZeldaCreaturesFavoritesViewModel
import coil3.compose.AsyncImage

@Composable
fun ZeldaCreaturesFavoritesScreen(navigateToDetailScreen: (Int) -> Unit){
    val viewModel = viewModel { ZeldaCreaturesFavoritesViewModel() }
    val favoritesCreatures = viewModel.likedCreatures
    val isLoading = viewModel.isLoading

    ZeldaCreaturesFavoritesScreenArguments(navigateToDetailScreen, favoritesCreatures, isLoading)
}

@Composable
fun ZeldaCreaturesFavoritesScreenArguments(
    navigateToDetailScreen: (Int) -> Unit,
    favoritesCreatures: MutableState<List<Creature>>,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        if (isLoading) {
            ContentLoading()
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                TitleText("Favorite creatures")

                Box(modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight()){
                    LazyColumn {
                        if (favoritesCreatures.value.isEmpty()) {
                            item {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(
                                        text = "There aren't any favorite creatures (yet)!",
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                }
                            }
                        }
                        val rows = favoritesCreatures.value.chunked(3)
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

