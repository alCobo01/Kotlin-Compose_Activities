package cat.itb.m78.exercices.projecteMapsCamera

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.TempleBuddhist
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.itb.m78.exercices.projecteMapsCamera.screens.AddMarkerScreen
import cat.itb.m78.exercices.projecteMapsCamera.screens.MapsScreen
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object MapsScreen
    @Serializable
    data object CameraScreen
    @Serializable
    data class AddMarkerScreen(val latitude: Double, val longitude: Double)
    @Serializable
    data object ListSpotsScreen
    @Serializable
    data class DetailSpotScreen(val id: Int)
}

@Composable
fun MapsAndCamera() {
    val navController = rememberNavController()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
                ModalDrawerSheet {
                Row(modifier = Modifier.padding(16.dp)) {
                    Icon(imageVector = Icons.Filled.TempleBuddhist, contentDescription = null)
                    Text("Monuments", modifier = Modifier.padding(start = 8.dp))
                }

                HorizontalDivider()

                NavigationDrawerItem(
                    label = {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Icon(imageVector = Icons.Filled.Map, contentDescription = null)
                            Text("Map", modifier = Modifier.padding(start = 8.dp))
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(Destination.MapsScreen)
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = null)
                            Text("Saved monuments", modifier = Modifier.padding(start = 8.dp))
                        }
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(Destination.MapsScreen)
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        }
    ){
        NavHost(navController = navController, startDestination = Destination.MapsScreen ){
            composable<Destination.MapsScreen> {
                MapsScreen(drawerState, scope)
            }

            composable<Destination.AddMarkerScreen> { backStack ->
                val latitude = backStack.toRoute<Destination.AddMarkerScreen>().latitude
                val longitude = backStack.toRoute<Destination.AddMarkerScreen>().longitude

                AddMarkerScreen(
                    navigateToMapScreen = { navController.navigate(Destination.MapsScreen) },
                    latitude = latitude,
                    longitude = longitude
                )
            }
        }
    }
}