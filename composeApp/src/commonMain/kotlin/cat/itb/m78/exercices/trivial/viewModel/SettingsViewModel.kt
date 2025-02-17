package cat.itb.m78.exercices.trivial.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

enum class TrivialDifficulty{ Easy, Normal, Hard }
enum class TrivialTheme{ Historia, Ciencia, Esports, Pop }

data class TrivialSettings(
    val difficulty: TrivialDifficulty = TrivialDifficulty.Normal,
    val theme: TrivialTheme = TrivialTheme.Pop,
    val questionsPerGame: Int = 10,
    val timePerGame: Float = 5f
)

data object TrivialSettingsManager{
    private var settings = TrivialSettings()
    fun update(newSettings: TrivialSettings){
        settings = newSettings
    }
    fun get() = settings
}

class SettingsViewModel: ViewModel(){
    var selectedDifficulty by mutableStateOf(TrivialSettingsManager.get().difficulty)
    var selectedTheme by mutableStateOf(TrivialSettingsManager.get().theme)
    var selectedRounds by mutableStateOf(TrivialSettingsManager.get().questionsPerGame)
    var selectedTime by mutableStateOf(TrivialSettingsManager.get().timePerGame)

    fun updateDifficulty(difficulty: TrivialDifficulty) {
        selectedDifficulty = difficulty
        saveSettings()
    }

    fun updateTheme(theme: TrivialTheme){
        selectedTheme = theme
        saveSettings()
    }

    fun updateRounds(rounds: Int) {
        selectedRounds = rounds
        saveSettings()
    }

    fun updateTime(time: Float){
        selectedTime = time
        saveSettings()
    }

    private fun saveSettings() {
        TrivialSettingsManager.update(
            TrivialSettings(
                difficulty = selectedDifficulty,
                theme = selectedTheme,
                questionsPerGame = selectedRounds,
                timePerGame = selectedTime
            )
        )
    }

}
