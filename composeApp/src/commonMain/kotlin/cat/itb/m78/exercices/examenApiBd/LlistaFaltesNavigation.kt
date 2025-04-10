package cat.itb.m78.exercices.examenApiBd

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
import cat.itb.m78.exercices.examenApiBd.screens.LlistaAlumnesContadorScreen
import cat.itb.m78.exercices.examenApiBd.screens.LlistaAlumnesScreen
import cat.itb.m78.exercices.examenApiBd.screens.LlistaFaltesScreen
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object LlistaAlumnesScreen
    @Serializable
    data object LlistaFaltesScreen
    @Serializable
    data object LlistaAlumnesContadorScreen
}

@Composable
fun LlistaAssistencia(){
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar {
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Destination.LlistaAlumnesScreen) },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                label = { Text("Alumnes") }
            )

            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Destination.LlistaAlumnesContadorScreen) },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                label = { Text("Alumnes contador") }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(Destination.LlistaFaltesScreen) },
                icon = { Icon(imageVector = Icons.Default.Star, contentDescription = null) },
                label = { Text("Faltes") }
            )
        }
    }) {
        NavHost(navController = navController, startDestination = Destination.LlistaAlumnesScreen){
            composable<Destination.LlistaAlumnesScreen> {
                LlistaAlumnesScreen()
            }

            composable<Destination.LlistaAlumnesContadorScreen> {
                LlistaAlumnesContadorScreen()
            }

            composable<Destination.LlistaFaltesScreen> {
                LlistaFaltesScreen()
            }
        }
    }
}