package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.trivial.SettingsViewModel
import cat.itb.m78.exercices.trivial.TrivialDifficulty
import cat.itb.m78.exercices.trivial.brush

@Composable
fun SettingsScreen(navigateToMenuScreen: () -> Unit) {
    val settingsViewModel: SettingsViewModel = viewModel { SettingsViewModel() }
    SettingsScreenView(navigateToMenuScreen, settingsViewModel)
}

@Composable
fun SettingsScreenView(navigateToMenuScreen: () -> Unit, viewModel: SettingsViewModel){
    var expandedDifficulty by remember { mutableStateOf(false) }
    var difficultyOptions = TrivialDifficulty.entries
    var roundsOptions = listOf(5, 10, 15)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        Column {
            TextField(
                readOnly = true,
                value = viewModel.selectedDifficulty.name,
                onValueChange = {},
                label = { Text("Difficulty") },
                trailingIcon = {
                    IconButton(onClick = { expandedDifficulty = !expandedDifficulty }) {
                        Icon(Icons.Filled.ArrowDropDown, "dropdown arrow")
                    }
                },
                modifier = Modifier.fillMaxWidth() // Fill width for TextField
            )
            DropdownMenu(
                expanded = expandedDifficulty,
                onDismissRequest = { expandedDifficulty = false }
            ) {
                difficultyOptions.forEach { difficulty ->
                    DropdownMenuItem(
                        text = { Text(text = difficulty.name) },
                        onClick = {
                            viewModel.updateDifficulty(difficulty)
                            expandedDifficulty = false
                        }
                    )
                }
            }
        }

        // Rounds Radio Buttons
        Text("Rounds", style = MaterialTheme.typography.bodyLarge)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            roundsOptions.forEach { rounds ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = viewModel.selectedRounds == rounds,
                            onClick = {
                                viewModel.updateRounds(rounds)
                            }
                        )
                        Text(text = rounds.toString())
                    }
                }
            }
        }

        // Time per round Slider (Example - you might need to adjust the range and display)
        // ... (Slider - similar changes to use viewModel for state and updates) ...

        // Return to menu Button
        Button(onClick = navigateToMenuScreen) {
            Text("Return to menu")
        }
    }
}