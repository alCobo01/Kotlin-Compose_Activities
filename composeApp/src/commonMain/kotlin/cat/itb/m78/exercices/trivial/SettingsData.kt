package cat.itb.m78.exercices.trivial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

enum class TrivialDifficulty{ Easy, Normal, Hard }

data class TrivialSettings(
    val difficulty: TrivialDifficulty = TrivialDifficulty.Normal,
    val questionsPerGame: Int = 1
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
    var selectedRounds by mutableStateOf(TrivialSettingsManager.get().questionsPerGame)

    fun updateDifficulty(difficulty: TrivialDifficulty){
        selectedDifficulty = difficulty
        saveSettings()
    }

    fun updateRounds(rounds: Int) {
        selectedRounds = rounds
        saveSettings()
    }

    private fun saveSettings() {
        TrivialSettingsManager.update(
            TrivialSettings(
                difficulty = selectedDifficulty,
                questionsPerGame = selectedRounds,
            )
        )
    }

}
