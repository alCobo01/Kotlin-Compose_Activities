package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.trivial.GameViewModel
import cat.itb.m78.exercices.trivial.Question
import cat.itb.m78.exercices.trivial.SettingsViewModel
import cat.itb.m78.exercices.trivial.brush
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@Composable
fun GameScreen(navigateToResultScreen: () -> Unit){
    val viewModel: GameViewModel = viewModel { GameViewModel() }
    var currentQuestion by remember { mutableStateOf<Question?>(null) }

    LaunchedEffect(Unit){
        currentQuestion = viewModel.randomQuestion()
    }

    GameScreenView(viewModel, currentQuestion, navigateToResultScreen)
}

@Composable
fun GameScreenView(viewModel: GameViewModel, currentQuestion : Question?, navigateToResultScreen: () -> Unit){
    var currentProgress by remember { mutableStateOf(0f) }
    val settingsData: SettingsViewModel = viewModel { SettingsViewModel() }
    val scope = rememberCoroutineScope()

    var timeLeft by remember{ mutableStateOf(settingsData.selectedTime) }
    LaunchedEffect(timeLeft){
        delay(1.seconds)
        timeLeft--
        if(timeLeft.toInt() ==0){
            println("Hola")
        }
    }

    LaunchedEffect(Unit) {
        if (viewModel.gameFinished) {
            navigateToResultScreen()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        if (viewModel.mostrarResultat) Text(viewModel.roundText)

        if (currentQuestion != null) {
            Text(currentQuestion.text)
            Row {
                Button(onClick = {
                    viewModel.checkQuestion(0, navigateToResultScreen)

                } ){
                    Text(currentQuestion.options[0])}
                Button(onClick = { viewModel.checkQuestion(1, navigateToResultScreen) } ){
                    Text(currentQuestion.options[1])}
            }
            Row {
                Button(onClick = { viewModel.checkQuestion(2, navigateToResultScreen) } ){
                    Text(currentQuestion.options[2])}
                Button(onClick = { viewModel.checkQuestion(3, navigateToResultScreen) } ){
                    Text(currentQuestion.options[3])}
            }

            LinearProgressIndicator(
                progress = { (10-timeLeft)/10f },
                drawStopIndicator = {},
                gapSize = 0.dp
            )
            Text("Ronda ${viewModel.currentRound} de ${viewModel.totalRounds}")
            Text("Punts: ${viewModel.score}")
        }

    }
}
