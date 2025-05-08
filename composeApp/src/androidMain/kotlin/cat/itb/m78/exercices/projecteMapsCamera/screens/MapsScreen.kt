package cat.itb.m78.exercices.projecteMapsCamera.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MapsScreen(navigateToAddMarkerScreen: (Double, Double) -> Unit, drawerState: DrawerState, scope: CoroutineScope){
    val viewModel = viewModel { MapViewModel() }

    MapsScreenArguments(navigateToAddMarkerScreen, drawerState, scope, viewModel.monumentsList.value)
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapsScreenArguments(navigateToAddMarkerScreen: (Double, Double) -> Unit,
    drawerState: DrawerState, scope: CoroutineScope, monumentList: List<Monuments>){

    val itbLocation = LatLng(41.453269958496094, 2.1865615844726562)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(itbLocation, 15f)
    }

    val bottomSheetState = rememberModalBottomSheetState()
    var longPressPosition by remember { mutableStateOf<LatLng?>(null) }
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
                //Marcador examen
                Marker(
                    state = MarkerState(position = itbLocation),
                    title = "Institut Tecnològic de Barcelona",
                    snippet = "ITB",
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
                )

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
                    Marker(
                        state = MarkerState(pos),
                        title = "New monument",
                        snippet = "Touch to add",
                        icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)
                    )
                }
            }

            if (showDialog && longPressPosition != null) {
                ModalBottomSheet(
                    onDismissRequest = { showDialog = false; longPressPosition = null },
                    sheetState = bottomSheetState
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("¿Do you want to add a monument here?")
                        Spacer(Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextButton(onClick = {
                                showDialog = false
                                longPressPosition = null
                            }) {
                                Text("No")
                            }
                            TextButton(onClick = {
                                showDialog = false
                                navigateToAddMarkerScreen(
                                    longPressPosition!!.latitude,
                                    longPressPosition!!.longitude
                                )
                                longPressPosition = null
                            }) {
                                Text("Yes")
                            }
                        }
                    }
                }
            }
        }
    }
}