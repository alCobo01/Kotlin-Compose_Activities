package cat.itb.m78.exercices.projecteAPI

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.itb.m78.exercices.projecteAPI.screens.ZeldaCreaturesDetailScreen
import cat.itb.m78.exercices.projecteAPI.screens.ZeldaCreaturesFavoritesScreen
import cat.itb.m78.exercices.projecteAPI.screens.ZeldaCreaturesListScreen
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object ZeldaCreaturesListScreen
    @Serializable
    data class ZeldaCreaturesDetailScreen(val id: Int)
    @Serializable
    data object ZeldaCreaturesFavoritesScreen
}

@Composable
fun ZeldaCreatures(){
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar{
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Destination.ZeldaCreaturesListScreen) },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                label = { Text("Home") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Destination.ZeldaCreaturesFavoritesScreen) },
                icon = { Icon(imageVector = Icons.Default.Star, contentDescription = null) },
                label = { Text("Favorites") }
            )
        }
    }) {
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

            composable<Destination.ZeldaCreaturesFavoritesScreen> {
                ZeldaCreaturesFavoritesScreen()
            }
        }
    }
}