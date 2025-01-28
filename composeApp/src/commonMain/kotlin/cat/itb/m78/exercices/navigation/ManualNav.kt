package cat.itb.m78.exercices.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.datetime.Month

private sealed interface Screen {
    data object InitialScreen : Screen
    data object Screen1 : Screen
    data object Screen2 : Screen
    data class Screen3(val message: String) : Screen
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
        Screen.InitialScreen -> InitialScreen(
            navigateToScreen1 = { viewModel.navigateTo(Screen.Screen1) },
            navigateToScreen2 = { viewModel.navigateTo(Screen.Screen2) },
            navigateToScreen3 = { message -> viewModel.navigateTo(Screen.Screen3(message)) }
        )
        Screen.Screen1 -> Screen1(
            navigateBack = { viewModel.navigateTo(Screen.InitialScreen) }
        )
        Screen.Screen2 -> Screen2(
            navigateBack = { viewModel.navigateTo(Screen.InitialScreen) }
        )
        is Screen.Screen3 -> Screen3(
            message = currentScreen.message,
            navigateBack = { viewModel.navigateTo(Screen.InitialScreen)}
        )
    }
}

@Composable
fun InitialScreen(
    navigateToScreen1: () -> Unit,
    navigateToScreen2: () -> Unit,
    navigateToScreen3: (String) -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = navigateToScreen1){
            Text("Screen 1")
        }
        Button(onClick = navigateToScreen2){
            Text("Screen 2")
        }
        Button(onClick = { navigateToScreen3("hola") }){
            Text("Screen 3 amb hola")
        }
        Button(onClick = { navigateToScreen3("adeu") }){
            Text("Screen 3 amb adeu")
        }
    }
}

@Composable
fun Screen1(navigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla 1")
        Button(onClick = navigateBack) {
            Text("Tornar a l'inici")
        }
    }
}

@Composable
fun Screen2(navigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla 2")
        Button(onClick = navigateBack) {
            Text("Tornar a l'inici")
        }
    }
}

@Composable
fun Screen3(message: String, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(message)
        Button(onClick = navigateBack) {
            Text("Tornar a l'inici")
        }
    }
}