package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cat.itb.m78.exercices.trivial.brush
import cat.itb.m78.exercices.trivial.viewModel.GameViewModel

@Composable
fun ResultScreen(navigateToMenuScreen: () -> Unit, viewModel: GameViewModel){
    ResultScreenView(navigateToMenuScreen, viewModel)
}

@Composable
fun ResultScreenView(navigateToMenuScreen: () -> Unit, viewModel: GameViewModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        Text("Has aconseguit")
        Text("${viewModel.scoreViewModel.currentScore}")
        Button(onClick = navigateToMenuScreen){ Text("Tornar al menú inicial!") }
    }
}