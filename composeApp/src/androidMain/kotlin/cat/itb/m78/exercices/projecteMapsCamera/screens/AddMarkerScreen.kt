package cat.itb.m78.exercices.projecteMapsCamera.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteMapsCamera.DTOs.InsertMarker
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.AddMarkerViewModel
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.CameraViewModel
import coil3.compose.AsyncImage
import com.google.android.gms.maps.model.LatLng
import kotlin.reflect.KFunction1

@Composable
fun AddMarkerScreen(
    savedStateHandle: SavedStateHandle,
    navigateToMapScreen: () -> Unit,
    navigateToCameraScreen: () -> Unit,
    latLng: LatLng
){
    val viewModel = viewModel { AddMarkerViewModel(savedStateHandle) }
    val photoUri = viewModel.photoUri.collectAsState().value
    AddMarkerScreenArguments(navigateToMapScreen, navigateToCameraScreen, viewModel :: addMarker, latLng, photoUri)
}

@Composable
fun AddMarkerScreenArguments(
        navigateToMapScreen: () -> Unit,
        navigateToCameraScreen: () -> Unit,
        addMarker: KFunction1<InsertMarker, Unit>,
        latLng: LatLng,
        photoUri: String?)
{
    var marker by remember { mutableStateOf(InsertMarker(latLng.latitude, latLng.longitude, "", "", "")) }

    var showDialog by remember { mutableStateOf(false) }
    var showTitleErrorDialog by remember { mutableStateOf(false) }

    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            marker.imageUri = uri.toString()
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    val cameraVm = viewModel { CameraViewModel() }

    val savedUri by cameraVm.savedPhotoUri

    if (photoUri != null) {
        marker.imageUri = photoUri
    }

    LaunchedEffect(savedUri) {
        savedUri?.let {
            marker = marker.copy(imageUri = it.toString())
        }
    }

    var showCamera by remember { mutableStateOf(false) }

    LaunchedEffect(showCamera) {
        if (showCamera) {
            navigateToCameraScreen()
            showCamera = false
        }
    }

    Log.d("AddMarkerScreen", "Marker: $marker")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        TextField(
            value = marker.title,
            onValueChange = { marker = marker.copy(title = it) },
            label = { Text("Monument name") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = marker.description,
            onValueChange = { marker = marker.copy(description = it) },
            label = { Text("Monument description") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { showDialog = true }
        ){
            Icon(Icons.Filled.CameraAlt, contentDescription = "Camera")
        }

        Button(
            onClick = {
                if (marker.title.isEmpty()){
                    showTitleErrorDialog = true
                } else {
                    addMarker(marker)
                    Thread.sleep(4000)
                    navigateToMapScreen()
                }
            }
        ){
            Text("Add marker!")
        }

        if (showDialog){
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Select Photo Source") },
                text = { Text("Choose how to add a photo:") },
                confirmButton = {
                    Column {
                        Button(onClick = {
                            showCamera = true
                            showDialog = false
                        }) {
                            Text("Use Camera")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = {
                            showDialog = false
                            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                        }) {
                            Text("Choose from Gallery")
                        }
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        if (showTitleErrorDialog) {
            AlertDialog(
                onDismissRequest = { showTitleErrorDialog = false },
                title = { Text("Error!") },
                text = { Text("The title is mandatory") },
                confirmButton = {
                    Button(onClick = { showTitleErrorDialog = false }) {
                        Text("Ok")
                    }
                }
            )
        }

    }
}


