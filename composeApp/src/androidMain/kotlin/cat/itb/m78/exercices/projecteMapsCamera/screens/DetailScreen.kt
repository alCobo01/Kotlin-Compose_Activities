package cat.itb.m78.exercices.projecteMapsCamera.screens

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cat.itb.m78.exercices.db.Monuments
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.DetailViewModel

@Composable
fun DetailScreen(monumentId: Int, navController: NavController){
    val viewModel = viewModel { DetailViewModel(monumentId) }

    DetailScreenArguments(viewModel.monument, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenArguments(
    monument: MutableState<Monuments>,
    navController: NavController
) {
    // Log the image URI to help debug
    LaunchedEffect(monument.value) {
        Log.d("DetailScreen", "Loading image URI: ${monument.value.imageUri}")
        Log.d("DetailScreen", "Is URI valid: ${isValidUri(monument.value.imageUri)}")
    }
    
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            if (monument.value.imageUri?.isNotEmpty() == true) {
                AsyncImage(
                    model = monument.value.imageUri,
                    contentDescription = monument.value.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    onLoading = { Log.d("DetailScreen", "Image loading...") },
                    onSuccess = { Log.d("DetailScreen", "Image loaded successfully") },
                    onError = { Log.e("DetailScreen", "Error loading image: $it") }
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.6f))
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    MaterialTheme.colorScheme.surface
                                )
                            )
                        )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                if (monument.value.imageUri?.isNotEmpty() == true) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .aspectRatio(1f), // Square aspect ratio
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = monument.value.imageUri,
                                contentDescription = monument.value.title,
                                contentScale = ContentScale.Fit, // Use Fit to show entire image
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp),
                                onLoading = { Log.d("DetailScreen", "Card image loading...") },
                                onSuccess = { Log.d("DetailScreen", "Card image loaded successfully") },
                                onError = { Log.e("DetailScreen", "Error loading card image: $it") }
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Text(
                            text = monument.value.title,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        HorizontalDivider(
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .fillMaxWidth(0.3f)
                                .height(2.dp),
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        monument.value.description?.let {
                            Text(
                                text = it.ifEmpty { "No description available" },
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }

                        Text(
                            text = "Location",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Lat: ${monument.value.latitude}, Long: ${monument.value.longitude}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

// Helper function to validate URIs
private fun isValidUri(uriString: String?): Boolean {
    return try {
        uriString?.let { Uri.parse(it) != null } ?: false
    } catch (e: Exception) {
        Log.e("DetailScreen", "Invalid URI format: $uriString", e)
        false
    }
}
