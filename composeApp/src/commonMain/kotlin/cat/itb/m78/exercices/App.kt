package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.viewModel.CounterApp

@Composable
internal fun App() = AppTheme {
    CounterApp()
}
