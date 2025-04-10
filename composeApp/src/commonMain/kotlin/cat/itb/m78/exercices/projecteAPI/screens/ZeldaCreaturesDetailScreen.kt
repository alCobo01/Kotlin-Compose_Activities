package cat.itb.m78.exercices.projecteAPI.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteAPI.ContentLoading
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.viewModels.ZeldaCreaturesDetailViewModel
import coil3.compose.AsyncImage
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cat.itb.m78.exercices.projecteAPI.brush

@Composable
fun ZeldaCreaturesDetailScreen(navigateToListScreen: () -> Unit, selectedCreatureName : Int){
    val viewModel = viewModel { ZeldaCreaturesDetailViewModel(selectedCreatureName) }

    ZeldaCreaturesDetailScreenArguments(navigateToListScreen, viewModel)
}

@Composable
fun ZeldaCreaturesDetailScreenArguments(
    navigateToListScreen: () -> Unit,
    viewModel: ZeldaCreaturesDetailViewModel
){
    val selectedCreature : MutableState<Creature> = viewModel.selectedCreature

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    ) {
        if (selectedCreature.value.name.isEmpty()) {
            ContentLoading()
        } else {
            Card(
                modifier = Modifier.fillMaxHeight(0.8f).fillMaxWidth(0.6f),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(
                        alpha = 0.5f
                    )
                ),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    IconButton(
                        onClick = { viewModel.changeFavState(selectedCreature.value.id) },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                            .size(70.dp)
                    ) {
                        Icon(
                            imageVector = if (viewModel.isLiked.value) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth(0.6f)
                        ) {
                            Text(
                                text = selectedCreature.value.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Spacer(Modifier.height(32.dp))

                            AsyncImage(
                                model = selectedCreature.value.image,
                                contentDescription = selectedCreature.value.name,
                                modifier = Modifier
                                    .size(300.dp)
                                    .clip(shape = RoundedCornerShape(16.dp))
                            )

                            Spacer(Modifier.height(32.dp))

                            Text(
                                text = selectedCreature.value.description,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                                fontSize = 18.sp,
                            )


                            Spacer(Modifier.height(32.dp))

                            OutlinedButton(
                                onClick = navigateToListScreen,
                                border = BorderStroke(
                                    width = 1.5.dp,
                                    color = MaterialTheme.colorScheme.primary
                                ),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = MaterialTheme.colorScheme.primary
                                ),
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(
                                    "Return to all creatures!",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}