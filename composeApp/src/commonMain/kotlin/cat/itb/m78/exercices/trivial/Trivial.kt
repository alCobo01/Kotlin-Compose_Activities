package cat.itb.m78.exercices.trivial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.navigation.TicViewModel
import cat.itb.m78.exercices.trivial.screens.GameScreen
import cat.itb.m78.exercices.trivial.screens.GameViewModel
import cat.itb.m78.exercices.trivial.screens.MenuScreen
import cat.itb.m78.exercices.trivial.screens.ResultScreen
import cat.itb.m78.exercices.trivial.screens.SettingsScreen
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.VeniteAdoremus
import m78exercices.composeapp.generated.resources.trivialLogo
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

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

    NavHost(navController = navController, startDestination = Destination.MenuScreen){
        composable<Destination.MenuScreen> {
            MenuScreen(
                navigateToGameScreen = { navController.navigate(Destination.GameScreen) },
                navigateToSettingsScreen = { navController.navigate(Destination.SettingsScreen) }
            )
        }
        composable<Destination.SettingsScreen> {
            SettingsScreen (
                navigateToMenuScreen = { navController.navigate(Destination.MenuScreen) }
            )
        }

        composable<Destination.GameScreen> {
            val viewModel: GameViewModel = viewModel { GameViewModel() }

            GameScreen (
                navigateToResultScreen = { navController.navigate(Destination.ResultScreen) },
                viewModel = viewModel
            )
        }

        composable<Destination.ResultScreen> {
            ResultScreen (
                navigateToMenuScreen = { navController.navigate(Destination.MenuScreen) }
            )
        }
    }
}






