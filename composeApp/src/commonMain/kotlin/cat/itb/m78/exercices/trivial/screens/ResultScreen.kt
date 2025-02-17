package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.itb.m78.exercices.trivial.brush
import cat.itb.m78.exercices.trivial.viewModel.GameViewModel
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.VeniteAdoremus
import org.jetbrains.compose.resources.Font

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
        Text(
            text = "Puntuació final: ",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "${viewModel.scoreViewModel.currentScore} punts!",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(Res.font.VeniteAdoremus))
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = navigateToMenuScreen, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5E5E5E)
        )){ Text("Tornar al menú inicial!") }
    }
}