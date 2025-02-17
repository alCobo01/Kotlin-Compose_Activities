package cat.itb.m78.exercices.trivial.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.trivial.Question
import cat.itb.m78.exercices.trivial.questions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel(private val settingsViewModel: SettingsViewModel) : ViewModel(){
    val scoreViewModel = ScoreViewModel()

    var roundText by mutableStateOf("")
    var mostrarResultat by mutableStateOf(false)
    var currentQuestion by mutableStateOf<Question?>(null)
    var gameFinished by mutableStateOf(false)
    var currentRound by mutableStateOf(1)

    init {
        resetGame()
    }

    fun resetGame() {
        scoreViewModel.resetScore()
        currentRound = 1
        gameFinished = false
        currentQuestion = randomQuestion()
        roundText = ""
    }

    private fun randomQuestion(): Question {
        var theme: String
        var difficulty: String
        var question: Question

        do {
            question = questions.random()
            theme = question.category
            difficulty = question.difficulty
        } while (theme != settingsViewModel.selectedTheme.toString() || difficulty != settingsViewModel.selectedDifficulty.toString())

        return question
    }

    fun checkQuestion(userAnswer: Int, navigateToResultScreen: () -> Unit){
        if (!gameFinished) {
            when (userAnswer) {
                -1 -> {
                    roundText = "Temps esgotat!"
                }
                currentQuestion?.correctAnswerIndex -> {
                    roundText = "Resposta correcta!"
                    scoreViewModel.incrementScore()
                }
                else -> {
                    roundText = "Resposta incorrecta..."
                }
            }
            mostrarResultat = true
            viewModelScope.launch {
                delay(5000)
                mostrarResultat = false
                if (currentRound >= settingsViewModel.selectedRounds) {
                    gameFinished = true
                    navigateToResultScreen()
                } else {
                    currentQuestion = randomQuestion()
                    currentRound++
                }
            }
        }
    }
}
