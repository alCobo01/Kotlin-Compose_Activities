package cat.itb.m78.exercices.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

private sealed interface Screen {
    data object InitialScreen : Screen
    data object Screen1 : Screen
    data object Screen2 : Screen
    data class Screen3(val message: Screen) : Screen
}

private class ManualAppViewModel : ViewModel(){
    val currentScreen = mutableStateOf<Screen>(Screen.InitialScreen)

    fun navigateTo(screen: Screen){
        currentScreen.value = screen
    }
}

@Composable
fun ManualNav(){
    val viewModel = viewModel { ManualAppViewModel() }
    val currentScreen = viewModel.currentScreen.value
    when (currentScreen){
        Screen.InitialScreen -> TODO()
        Screen.Screen1 -> Screen.Screen1(
            navigateToScreen1 = { viewModel.navigateTo(Screen.Screen1) }
        )
        Screen.Screen2 -> TODO()
        is Screen.Screen3 -> TODO()
    }
}

@Composable
fun Screen1()