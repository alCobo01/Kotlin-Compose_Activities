package cat.itb.m78.exercices.projecteMapsCamera.screens

import androidx.compose.runtime.Composable

@Composable
fun CameraTakePhotoScreen(
    navigateToViewPhotoScreen: () -> Unit,
    viewModel: cat.itb.m78.exercices.projecteMapsCamera.viewModels.CameraViewModel
) {
    // 1) Llamamos a la función de la cámara
    viewModel.takePhoto(context = androidx.compose.ui.platform.LocalContext.current)
    // 2) Navegamos a la pantalla de vista previa
    navigateToViewPhotoScreen()
}