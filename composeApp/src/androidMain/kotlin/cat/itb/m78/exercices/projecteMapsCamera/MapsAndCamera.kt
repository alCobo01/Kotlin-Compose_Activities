package cat.itb.m78.exercices.projecteMapsCamera

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.projecteMapsCamera.screens.MapsScreen
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object MapsScreen
    @Serializable
    data object CameraScreen
    @Serializable
    data object ListSpotsScreen
    @Serializable
    data class DetailSpotScreen(val id: Int)
}

@Composable
fun MapsAndCamera() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.MapsScreen,
    ){
        composable<Destination.MapsScreen> {
            MapsScreen()
        }
    }


}