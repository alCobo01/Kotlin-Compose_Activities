package cat.itb.m78.exercices.api.embassaments

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

object Destination{
    @Serializable
    data object EmbassamentListScreen
    @Serializable
    data class EmbassamentDetailScreen(val embassament: String)
}

@Composable
fun Embassaments(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.EmbassamentListScreen){
        composable<Destination.EmbassamentListScreen> {
            EmbassamentListScreen(
                navigateToSecondScreen = { navController.navigate(Destination.EmbassamentDetailScreen) }
            )
        }

        composable<Destination.EmbassamentDetailScreen> {
            EmbassamentDetailScreen(
                navigateToFirstScreen = { navController.navigate(Destination.EmbassamentListScreen) }
            )
        }

    }
}

