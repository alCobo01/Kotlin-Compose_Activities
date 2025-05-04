package cat.itb.m78.exercices.projecteMapsCamera.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.db.Monuments
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.MapViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MapsScreen(drawerState: DrawerState, scope: CoroutineScope){
    val viewModel = viewModel { MapViewModel() }

    MapsScreenArguments(drawerState, scope, viewModel.monumentsList.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapsScreenArguments(drawerState: DrawerState, scope: CoroutineScope, monumentList: List<Monuments>){
    val itbLocation = LatLng(41.4533, 2.18625)
    val cameraPositionState = rememberCameraPositionState() {
        position = CameraPosition.fromLatLngZoom(itbLocation, 15f)
    }

    var longPressPosition by remember { mutableStateOf<LatLng?>(LatLng(0.0, 0.0)) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Monuments",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.apply { if (isClosed) open() } } }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            GoogleMap(
                modifier = Modifier
                    .fillMaxSize(0.95f)
                    .clip(shape = RoundedCornerShape(20.dp)),
                cameraPositionState = cameraPositionState,
                onMapLongClick = { latLng ->
                    longPressPosition = latLng
                    showDialog = true
                }
            ) {
                //Marcadors guardats a la BBDD
                monumentList.forEach { monument ->
                    AdvancedMarker(
                        state = MarkerState(LatLng(monument.latitude, monument.longitude)),
                        title = monument.title,
                        snippet = monument.description
                    )
                }

                //Marcador que surt al pulsar
                longPressPosition?.let { pos ->
                    AdvancedMarker(
                        state = MarkerState(pos),
                        title = "New monument",
                        snippet = "Touch to add"
                    )
                }
            }

            if (showDialog && longPressPosition != null) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Add a new marker") },
                    text = {
                        Text("Do you want to add a new marker here?")
                    },
                    confirmButton = {
                        Button(onClick = {
                            // Llama a callback para crear en BD, etc.

                            showDialog = false
                            longPressPosition = null
                        }) {
                            Text("Yes")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            showDialog = false
                            longPressPosition = null
                        }) {
                            Text("No")
                        }
                    }
                )
            }

        }
    }
}
