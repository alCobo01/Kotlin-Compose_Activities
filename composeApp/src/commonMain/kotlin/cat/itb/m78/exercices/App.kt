package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.navigation.LibNav
import cat.itb.m78.exercices.navigation.ManualNav
import cat.itb.m78.exercices.navigation.TicTacToe
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.viewModel.CounterApp
import cat.itb.m78.exercices.viewModel.OthelloBoard
import cat.itb.m78.exercices.viewModel.ShoppingList

@Composable
fun App() = AppTheme {
    TicTacToe()
}
