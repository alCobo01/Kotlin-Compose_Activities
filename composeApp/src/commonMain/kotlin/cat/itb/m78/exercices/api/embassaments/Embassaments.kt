package cat.itb.m78.exercices.api.embassaments

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

object Destination{
    @Serializable
    data object EmbassamentFirstScreen
    @Serializable
    data object EmbassamentSecondScreen
}

@Composable
fun Embassaments(){
    val navController = rememberNavController()
    val viewModel : EmbassamentsViewModel = viewModel { EmbassamentsViewModel() }

    NavHost(navController = navController, startDestination = Destination.EmbassamentFirstScreen){
        composable<Destination.EmbassamentFirstScreen> {
            EmbassamentFirstScreen(
                navigateToSecondScreen = { navController.navigate(Destination.EmbassamentSecondScreen) },
                viewModel = viewModel
            )
        }

        composable<Destination.EmbassamentSecondScreen> {
            EmbassamentSecondScreen(
                navigateToFirstScreen = { navController.navigate(Destination.EmbassamentFirstScreen) },
                viewModel = viewModel
            )
        }

    }
}

