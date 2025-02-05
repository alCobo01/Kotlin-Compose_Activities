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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        modifier = Modifier.fillMaxSize().background(Color(0xFFF1C40F))
    ) {
        Text(
            text = "Trivial",
            fontSize = 60.sp,
            fontFamily = FontFamily(Font(Res.font.VeniteAdoremus))
        )
        Image(
            painter = painterResource(Res.drawable.trivialLogo),
            contentDescription = null,
            modifier = Modifier.size(200.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = navigateToGameScreen,
            modifier = Modifier.height(300.dp).width(300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3498DB)))
        { Text("Game") }

        Spacer(modifier = Modifier.padding(3.dp))

        Button(
            onClick = navigateToSettingsScreen,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3498DB))) { Text("Settings") }
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