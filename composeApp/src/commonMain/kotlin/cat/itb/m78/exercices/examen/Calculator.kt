package cat.itb.m78.exercices.examen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.examen.screens.CalculatorScreen
import cat.itb.m78.exercices.examen.screens.ResultatScreen
import kotlinx.serialization.Serializable

val brush = Brush.linearGradient(listOf(Color(0xFF63E07C), Color(0xFF578F62)))

object Destination{
    @Serializable
    data object CalculatorScreen
    @Serializable
    data object ResultatScreen
}

@Composable
fun Calculator(){
    val navController = rememberNavController()
    val viewModel: CalculatorViewModel = viewModel { CalculatorViewModel() }

    NavHost(navController = navController, startDestination = Destination.CalculatorScreen){
        composable<Destination.CalculatorScreen> {
            CalculatorScreen(
                navigateToResultatScreen = { navController.navigate(Destination.ResultatScreen) },
                viewModel = viewModel
            )
        }

        composable<Destination.ResultatScreen> {
            ResultatScreen(viewModel = viewModel)
        }
    }
}