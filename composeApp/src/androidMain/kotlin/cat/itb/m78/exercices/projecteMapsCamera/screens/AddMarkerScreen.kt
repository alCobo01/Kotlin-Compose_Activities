package cat.itb.m78.exercices.projecteMapsCamera.screens

import android.net.Uri
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteMapsCamera.DTOs.InsertMarker
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.AddMarkerViewModel
import kotlin.reflect.KFunction1

@Composable
fun AddMarkerScreen(navigateToMapScreen : () -> Unit, latitude : Double, longitude : Double){
    val viewModel = viewModel { AddMarkerViewModel() }
    val marker by remember { mutableStateOf(InsertMarker(latitude, longitude, "", "", "")) }

    AddMarkerScreenArguments(navigateToMapScreen, viewModel :: addMarker, marker)
}

@Composable
fun AddMarkerScreenArguments(
        navigateToMapScreen: () -> Unit,
        addMarker: KFunction1<InsertMarker, Unit>,
        marker: InsertMarker)
{
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            marker.imageUri = uri.toString()
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    var showDialog by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = marker.title,
            onValueChange = { marker.title = it },
            label = { Text("Monument name") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = marker.description,
            onValueChange = { marker.description = it },
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
                addMarker(marker)
                Thread.sleep(2000)
                navigateToMapScreen()
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

    }
}


