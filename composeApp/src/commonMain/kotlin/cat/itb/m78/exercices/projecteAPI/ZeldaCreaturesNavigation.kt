package cat.itb.m78.exercices.projecteAPI

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object ZeldaCreaturesListScreen
    @Serializable
    data class ZeldaCreaturesDetailScreen(val name: String)
}

@Composable
fun ZeldaCreatures(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.ZeldaCreaturesListScreen){
        composable<Destination.ZeldaCreaturesListScreen> {
            ZeldaCreaturesListScreen(
                navigateToDetailScreen = { creatureName: String ->
                    navController.navigate(Destination.ZeldaCreaturesDetailScreen(name = creatureName))
                }
            )
        }

        composable<Destination.ZeldaCreaturesDetailScreen> { backStack ->
            val creatureName = backStack.toRoute<Destination.ZeldaCreaturesDetailScreen>().name

            ZeldaCreaturesDetailScreen(
                navigateToListScreen = { navController.navigate(Destination.ZeldaCreaturesListScreen) },
                selectedCreatureName = creatureName
            )
        }
    }
}