package cat.itb.m78.exercices.projecteAPI.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteAPI.ContentLoading
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.viewModels.ZeldaCreaturesDetailViewModel
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

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

    if (selectedCreature.value.name.isEmpty()) {
        ContentLoading()
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(selectedCreature.value.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() })

            Spacer(Modifier.height(16.dp))

            val painter = rememberAsyncImagePainter(selectedCreature.value.image)
            val state by painter.state.collectAsState()

             when (state) {
                 is AsyncImagePainter.State.Empty,
                 is AsyncImagePainter.State.Loading -> {
                     Text("loading")
                 }

                is AsyncImagePainter.State.Error -> {
                    Text("Error loading image")
                }
                is AsyncImagePainter.State.Success -> {
                    Image(
                        painter = painter,
                        contentDescription = selectedCreature.value.name,
                        modifier = Modifier.height(200.dp)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(selectedCreature.value.description)

            Spacer(Modifier.height(16.dp))

            if(viewModel.isLiked.value) {
                Button(onClick = { viewModel.changeFavState(selectedCreature.value.id) }) { Text("Remove to favorites") }
            }
            else{
                Button(onClick = {viewModel.changeFavState(selectedCreature.value.id) }) { Text("Add to favorites") }
            }

            Button(onClick = navigateToListScreen){ Text("Return to all creatures!") }
        }

    }
}