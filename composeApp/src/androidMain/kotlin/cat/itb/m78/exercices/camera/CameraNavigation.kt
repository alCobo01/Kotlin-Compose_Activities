package cat.itb.m78.exercices.camera

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.camera.screens.CameraTakePhotoScreen
import cat.itb.m78.exercices.camera.screens.CameraViewPhoto
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object CameraTakePhoto
    @Serializable
    data object CameraViewPhoto
}

@Composable
fun Camera(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.CameraTakePhoto) {
        composable<Destination.CameraTakePhoto> {
            CameraTakePhotoScreen(navigateToViewPhotoScreen = { navController.navigate(Destination.CameraViewPhoto) })
        }

        composable<Destination.CameraViewPhoto> {
            CameraViewPhoto(navigateToTakePhotoScreen = { navController.navigate(Destination.CameraTakePhoto) })
        }

    }
}