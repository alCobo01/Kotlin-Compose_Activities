package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.itb.m78.exercices.trivial.viewModel.GameViewModel
import cat.itb.m78.exercices.trivial.viewModel.SettingsViewModel
import cat.itb.m78.exercices.trivial.brush
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun GameScreen(navigateToResultScreen: () -> Unit, viewModel: GameViewModel, settingsData: SettingsViewModel){
    GameScreenView(viewModel, settingsData, navigateToResultScreen)
}

@Composable
fun GameScreenView(viewModel: GameViewModel, settingsData: SettingsViewModel, navigateToResultScreen: () -> Unit){
    var timeLeft by remember { mutableStateOf(settingsData.selectedTime) }
    var isTimerRunning by remember { mutableStateOf(true) }
    var questionAnswered by remember { mutableStateOf(false) }
    var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) } // To track the user's selected answer

    val buttonColors = remember {
        mutableStateListOf(
            mutableStateOf(Color(0xFF5E5E5E)),
            mutableStateOf(Color(0xFF5E5E5E)),
            mutableStateOf(Color(0xFF5E5E5E)),
            mutableStateOf(Color(0xFF5E5E5E))
        )
    }

    LaunchedEffect(viewModel.currentQuestion) {
        questionAnswered = false
        timeLeft = settingsData.selectedTime
        isTimerRunning = true
        selectedAnswerIndex = null

        for (i in 0..3) {
            buttonColors[i].value = Color(0xFF5E5E5E)
        }
    }

    LaunchedEffect(timeLeft, isTimerRunning, questionAnswered){
        if (isTimerRunning && timeLeft > 0 && !questionAnswered){
            delay(1.seconds)
            timeLeft--
            if (timeLeft == 0f){
                isTimerRunning = false
                viewModel.checkQuestion(-1) { navigateToResultScreen() }
            }
        }
    }

    LaunchedEffect(viewModel.mostrarResultat) {
        if (viewModel.mostrarResultat && viewModel.currentQuestion != null) {
            val correctAnswerIndex = viewModel.currentQuestion!!.correctAnswerIndex
            buttonColors.forEachIndexed { index, mutableButtonColor ->
                mutableButtonColor.value =
                    if (index == correctAnswerIndex) {
                        Color(0xFF77DD77)
                    } else if (index == selectedAnswerIndex && index != correctAnswerIndex) {
                        Color(0xFFFF6961)
                    } else if (index != correctAnswerIndex){
                        Color(0xFFFF6961)
                    }
                    else {
                        Color(0xFFFF6961)
                    }
            }
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
        if (viewModel.mostrarResultat) {
            Text(text = viewModel.roundText, fontSize = 17.sp)
            Spacer(modifier = Modifier.padding(10.dp))
        }

        if (viewModel.currentQuestion != null) {
            Text(
                text = viewModel.currentQuestion!!.text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row {
                Button(onClick = {
                    if (!questionAnswered) {
                        isTimerRunning = false
                        questionAnswered = true
                        selectedAnswerIndex = 0
                        viewModel.checkQuestion(0) { navigateToResultScreen() }
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = buttonColors[0].value)
                ){Text(viewModel.currentQuestion!!.options[0])}

                Spacer(modifier = Modifier.padding(5.dp))

                Button(onClick = {
                    if (!questionAnswered) {
                        isTimerRunning = false
                        questionAnswered = true
                        selectedAnswerIndex = 1
                        viewModel.checkQuestion(1) { navigateToResultScreen() }
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = buttonColors[1].value))
                {Text(viewModel.currentQuestion!!.options[1])}
            }
            Row {
                Button(onClick = {
                    if (!questionAnswered) {
                        isTimerRunning = false
                        questionAnswered = true
                        selectedAnswerIndex = 2
                        viewModel.checkQuestion(2) { navigateToResultScreen() }
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = buttonColors[2].value)
                ){Text(viewModel.currentQuestion!!.options[2])}

                Spacer(modifier = Modifier.padding(5.dp))

                Button(onClick = {
                    if (!questionAnswered) {
                        isTimerRunning = false
                        questionAnswered = true
                        selectedAnswerIndex = 3
                        viewModel.checkQuestion(3) { navigateToResultScreen() }
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = buttonColors[3].value)
                ){Text(viewModel.currentQuestion!!.options[3])}
            }

            Spacer(modifier = Modifier.padding(10.dp))

            LinearProgressIndicator(
                progress = { if (settingsData.selectedTime > 0) {
                    timeLeft / settingsData.selectedTime
                } else { 0f }},
                drawStopIndicator = {},
                gapSize = 0.dp,
                color = Color.LightGray,
                trackColor = Color(0xFF5E5E5E),
                modifier = Modifier.height(10.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text("Ronda ${viewModel.currentRound} de ${settingsData.selectedRounds}")
            Text("Punts: ${viewModel.scoreViewModel.currentScore}")
        }

    }
}
