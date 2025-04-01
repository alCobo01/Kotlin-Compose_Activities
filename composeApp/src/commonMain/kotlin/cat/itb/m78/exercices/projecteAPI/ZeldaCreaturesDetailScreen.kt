package cat.itb.m78.exercices.projecteAPI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun ZeldaCreaturesDetailScreen(navigateToListScreen: () -> Unit, selectedCreatureName : String){
    val viewModel = viewModel { ZeldaCreaturesDetailViewModel(selectedCreatureName) }
    val selectedCreature = viewModel.selectedCreature

    ZeldaCreaturesDetailScreenArguments(navigateToListScreen, selectedCreature)
}


@Composable
fun ZeldaCreaturesDetailScreenArguments(navigateToListScreen: () -> Unit, selectedCreature : MutableState<Creature>){
    if (selectedCreature.value.name.isEmpty()) {
        Text(selectedCreature.value.name)
        AsyncImage(
            model = selectedCreature.value.image,
            contentDescription = selectedCreature.value.name
        )
    }
}