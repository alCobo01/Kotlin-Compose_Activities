package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.api.embassaments.Embassaments
import cat.itb.m78.exercices.examen.Calculator
import cat.itb.m78.exercices.examenApiBd.LlistaAssistencia
import cat.itb.m78.exercices.projecteAPI.ZeldaCreatures
import cat.itb.m78.exercices.sqldelight.messages.MessagesScreen
import cat.itb.m78.exercices.theme.AppTheme

@Composable
fun App() = AppTheme {
    LlistaAssistencia()
}
