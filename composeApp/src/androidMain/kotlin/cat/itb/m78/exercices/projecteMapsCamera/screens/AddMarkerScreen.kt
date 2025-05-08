package cat.itb.m78.exercices.projecteMapsCamera.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.projecteMapsCamera.DTOs.InsertMarker
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.AddMarkerViewModel
import com.google.android.gms.maps.model.LatLng
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1

@Composable
fun AddMarkerScreen(savedStateHandle: SavedStateHandle, navigateToMapScreen: () -> Unit,
    navigateToCameraScreen: () -> Unit, latLng: LatLng
) {
    val addMarkerViewModel = viewModel { AddMarkerViewModel(savedStateHandle) }
    val photoUri = addMarkerViewModel.photoUri.collectAsState().value

    val initialMarker = addMarkerViewModel.getMarkerState().apply {
        imageUri = photoUri ?: imageUri
        latitude = latLng.latitude
        longitude = latLng.longitude
    }

    AddMarkerScreenArguments(navigateToMapScreen, navigateToCameraScreen, addMarkerViewModel::addMarker,
        initialMarker, addMarkerViewModel::getLastPhotoUri) { marker ->
        addMarkerViewModel.saveMarkerState(marker)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMarkerScreenArguments(
    navigateToMapScreen: () -> Unit, navigateToCameraScreen: () -> Unit,
    addMarker: KFunction1<InsertMarker, Unit>, initialMarker: InsertMarker, getLastPhotoUri: KFunction0<String>,
    onMarkerChange: (InsertMarker) -> Unit
) {
    var marker by remember { mutableStateOf(initialMarker) }
    var showDialog by remember { mutableStateOf(false) }
    var showCamera by remember { mutableStateOf(false) }
    var showTitleErrorDialog by remember { mutableStateOf(false) }

    var lastPhotoUri by remember { mutableStateOf("") }
    lastPhotoUri = getLastPhotoUri()

    // Launcher to pick image from gallery
    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            marker = marker.copy(imageUri = uri.toString())
        } else {
            Log.e("PhotoPicker", "No image selected")
        }
    }

    // Update marker state to persist in ViewModel
    LaunchedEffect(marker) {
        onMarkerChange(marker)
    }

    // When selecting camera, navigate
    LaunchedEffect(showCamera) {
        if (showCamera) {
            navigateToCameraScreen()
            showCamera = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { navigateToMapScreen() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surfaceVariant,
                        MaterialTheme.colorScheme.surface)))
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = marker.title,
                    onValueChange = { marker = marker.copy(title = it) },
                    label = { Text("Name of the monument") },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = marker.description,
                    onValueChange = { marker = marker.copy(description = it) },
                    label = { Text("Description of the monument") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = { if (marker.imageUri.isBlank()) showDialog = true },
                    enabled = marker.imageUri.isBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = "Camera",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = if (marker.imageUri.isNotBlank()) "Photo added correctly!" else "Add photo",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                //Afegir última foto feta, examen
                if (lastPhotoUri != "null"){
                    Button(
                        onClick = { marker = marker.copy(imageUri = getLastPhotoUri()) },
                        enabled = marker.imageUri.isBlank(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (marker.imageUri.isNotBlank()) "Photo added correctly!" else "Add last taken photo",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }

                Button(
                    onClick = {
                        if (marker.title.isEmpty()) {
                            showTitleErrorDialog = true
                        } else {
                            addMarker(marker)
                            navigateToMapScreen()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add monument!")
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    "Select a source",
                    style = MaterialTheme.typography.headlineSmall
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "How do you want to add the photo?",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            showCamera = true
                            showDialog = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CameraAlt,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            "Use camera",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            showDialog = false
                            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Photo,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            "Choose from gallery",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            },
            confirmButton = { },
            dismissButton = {
                Button(
                    onClick = { showDialog = false },
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Text("Cancel")
                }
            },
            containerColor = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(24.dp),
            tonalElevation = 6.dp
        )
    }

    if (showTitleErrorDialog) {
        AlertDialog(
            onDismissRequest = { showTitleErrorDialog = false },
            title = { Text("Error!") },
            text = { Text("Title is mandatory") },
            confirmButton = {
                Button(
                    onClick = { showTitleErrorDialog = false }
                ) {
                    Text("Ok")
                }
            }
        )
    }
    }
}
