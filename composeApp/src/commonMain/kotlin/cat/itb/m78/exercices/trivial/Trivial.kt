package cat.itb.m78.exercices.trivial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
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
            GameScreen (
                navigateToResultScreen = { navController.navigate(Destination.ResultScreen) }
            )
        }

        composable<Destination.ResultScreen> {
            ResultScreen (
                navigateToMenuScreen = { navController.navigate(Destination.MenuScreen) }
            )
        }
    }
}

@Composable
fun MenuScreen(navigateToGameScreen: () -> Unit, navigateToSettingsScreen: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.trivialLogo),
            contentDescription = null,
            modifier = Modifier.size(150.dp).clip(CircleShape)
        )
    }
}

@Composable
fun SettingsScreen(navigateToMenuScreen: () -> Unit){

}

@Composable
fun GameScreen(navigateToResultScreen: () -> Unit){

}

@Composable
fun ResultScreen(navigateToMenuScreen: () -> Unit){

}