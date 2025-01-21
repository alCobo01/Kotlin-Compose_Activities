package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.viewModel.CounterApp
import cat.itb.m78.exercices.viewModel.ShoppingList

@Composable
fun App() = AppTheme {
    ShoppingList()
}
