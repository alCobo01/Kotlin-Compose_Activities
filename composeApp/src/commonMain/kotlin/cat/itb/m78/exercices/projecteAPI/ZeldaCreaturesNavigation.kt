package cat.itb.m78.exercices.projecteAPI

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.itb.m78.exercices.projecteAPI.Screens.ZeldaCreaturesDetailScreen
import cat.itb.m78.exercices.projecteAPI.Screens.ZeldaCreaturesListScreen
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object ZeldaCreaturesListScreen
    @Serializable
    data class ZeldaCreaturesDetailScreen(val id: Int)
}

@Composable
fun ZeldaCreatures(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.ZeldaCreaturesListScreen){
        composable<Destination.ZeldaCreaturesListScreen> {
            ZeldaCreaturesListScreen(
                navigateToDetailScreen = { creatureName: Int ->
                    navController.navigate(Destination.ZeldaCreaturesDetailScreen(id = creatureName))
                }
            )
        }

        composable<Destination.ZeldaCreaturesDetailScreen> { backStack ->
            val creatureName = backStack.toRoute<Destination.ZeldaCreaturesDetailScreen>().id

            ZeldaCreaturesDetailScreen(
                navigateToListScreen = { navController.navigate(Destination.ZeldaCreaturesListScreen) },
                selectedCreatureName = creatureName
            )
        }
    }
}