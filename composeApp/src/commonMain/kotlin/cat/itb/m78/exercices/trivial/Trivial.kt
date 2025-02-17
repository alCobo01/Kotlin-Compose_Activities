package cat.itb.m78.exercices.trivial

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.trivial.screens.GameScreen
import cat.itb.m78.exercices.trivial.screens.MenuScreen
import cat.itb.m78.exercices.trivial.screens.ResultScreen
import cat.itb.m78.exercices.trivial.screens.SettingsScreen
import cat.itb.m78.exercices.trivial.viewModel.GameViewModel
import cat.itb.m78.exercices.trivial.viewModel.SettingsViewModel
import kotlinx.serialization.Serializable

object Destination{
    @Serializable
    data object MenuScreen
    @Serializable
    data object SettingsScreen
    @Serializable
    data object GameScreen
    @Serializable
    data object ResultScreen
}

val brush = Brush.linearGradient(listOf(Color(0xFFFAE864), Color(0xFFFAD664), Color(0xFFFAAD64) ))

@Composable
fun Trivial(){
    val navController = rememberNavController()
    val settingsViewModel: SettingsViewModel = viewModel { SettingsViewModel() }
    val gameViewModel: GameViewModel = viewModel { GameViewModel(settingsViewModel) }


    NavHost(navController = navController, startDestination = Destination.MenuScreen){
        composable<Destination.MenuScreen> {
            MenuScreen(
                navigateToGameScreen = { navController.navigate(Destination.GameScreen) },
                navigateToSettingsScreen = { navController.navigate(Destination.SettingsScreen) },
                gameViewModel = gameViewModel
            )
        }
        composable<Destination.SettingsScreen> {
            SettingsScreen (
                navigateToMenuScreen = { navController.navigate(Destination.MenuScreen) },
                settingsViewModel = settingsViewModel
            )
        }

        composable<Destination.GameScreen> {
            GameScreen (
                navigateToResultScreen = { navController.navigate(Destination.ResultScreen) },
                viewModel = gameViewModel,
                settingsData = settingsViewModel
            )
        }

        composable<Destination.ResultScreen> {
            ResultScreen (
                navigateToMenuScreen = { navController.navigate(Destination.MenuScreen) },
                viewModel = gameViewModel
            )
        }
    }
}






