package cat.itb.m78.exercices.camera

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.camera.screens.CameraTakePhotoScreen
import cat.itb.m78.exercices.camera.screens.CameraViewPhotoScreen
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
    val viewModel = viewModel { CameraViewModel() }

    NavHost(navController = navController, startDestination = Destination.CameraTakePhoto) {
        composable<Destination.CameraTakePhoto> {
            CameraTakePhotoScreen(
                viewModel = viewModel,
                navigateToViewPhotoScreen = {
                    navController.navigate(Destination.CameraViewPhoto)
                }
            )
        }
        composable<Destination.CameraViewPhoto> {
            CameraViewPhotoScreen(
                viewModel = viewModel,
                navigateToCameraScreen = {
                    navController.navigate(Destination.CameraTakePhoto)
                }
            )
        }

    }
}