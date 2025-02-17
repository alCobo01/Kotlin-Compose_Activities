package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cat.itb.m78.exercices.trivial.viewModel.SettingsViewModel
import cat.itb.m78.exercices.trivial.viewModel.TrivialDifficulty
import cat.itb.m78.exercices.trivial.viewModel.TrivialTheme
import cat.itb.m78.exercices.trivial.brush
import kotlin.math.roundToInt

@Composable
fun SettingsScreen(navigateToMenuScreen: () -> Unit, settingsViewModel: SettingsViewModel) {
    SettingsScreenView(navigateToMenuScreen, settingsViewModel)
}

@Composable
fun SettingsScreenView(navigateToMenuScreen: () -> Unit, viewModel: SettingsViewModel){
    var expandedDifficulty by remember { mutableStateOf(false) }
    var expandedTheme by remember { mutableStateOf(false) }

    val themeOptions = TrivialTheme.entries
    val difficultyOptions = TrivialDifficulty.entries
    val roundsOptions = listOf(5, 10, 15)

    val buttonColor = Color(0xFF5E5E5E)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        Column {
            TextField(
                readOnly = true,
                value = viewModel.selectedTheme.name,
                onValueChange = {},
                label = { Text("Temàtica") },
                trailingIcon = {
                    IconButton(onClick = { expandedTheme = !expandedTheme }) {
                        Icon(Icons.Filled.ArrowDropDown, "dropdown arrow")
                    }
                }
            )
            DropdownMenu(
                expanded = expandedTheme,
                onDismissRequest = { expandedTheme = false }
            ) {
                themeOptions.forEach { theme ->
                    DropdownMenuItem(
                        text = { Text(text = theme.name) },
                        onClick = {
                            viewModel.updateTheme(theme)
                            expandedTheme = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Column {
            TextField(
                readOnly = true,
                value = viewModel.selectedDifficulty.name,
                onValueChange = {},
                label = { Text("Dificultat") },
                trailingIcon = {
                    IconButton(onClick = { expandedDifficulty = !expandedDifficulty }) {
                        Icon(Icons.Filled.ArrowDropDown, "dropdown arrow")
                    }
                }
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

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Nombre de rondes",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            roundsOptions.forEach { rounds ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = viewModel.selectedRounds == rounds,
                            onClick = {
                                viewModel.updateRounds(rounds)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = buttonColor
                            )
                        )
                        Text(text = rounds.toString())
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Temps per ronda",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Slider(
            value = viewModel.selectedTime,
            onValueChange = { viewModel.updateTime(it.roundToInt().toFloat()) },
            steps = 5,
            valueRange = 4f..10f,
            modifier = Modifier.width(300.dp),
            colors = SliderDefaults.colors(
                activeTrackColor = buttonColor,
                thumbColor = buttonColor
            )
        )
        Text(text = "${viewModel.selectedTime.toInt()} segons")

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = navigateToMenuScreen, colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor)
        ) { Text("Tornar al menú inicial") }
    }
}