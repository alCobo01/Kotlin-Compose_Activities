package cat.itb.m78.exercices.projecteMapsCamera.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.db.Monuments
import cat.itb.m78.exercices.projecteMapsCamera.viewModels.MapViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ListScreen(navigateToDetailScreen: (Int) -> Unit, drawerState: DrawerState, scope: CoroutineScope) {
    val viewModel = viewModel { MapViewModel() }
    ListScreenArguments(navigateToDetailScreen, drawerState, scope, viewModel.monumentsList.value, viewModel::deleteMonument)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreenArguments(
    navigateToDetailScreen: (monumentId: Int) -> Unit,
    drawerState: DrawerState,
    scope: CoroutineScope,
    monumentList: List<Monuments>,
    deleteMonument: (Int) -> Unit
) {

    val bottomSheetState = rememberModalBottomSheetState()
    var showDialog by remember { mutableStateOf(false) }
    var userInput by remember { mutableStateOf("") }
    var selectedMonumentId = 0

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Monuments list",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.apply { if (isClosed) open() } } }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                if (monumentList.isEmpty()) {
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.8f)
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "No monuments found",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Add your first monument from the map screen",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }

                if (monumentList.isNotEmpty()) {
                    item {
                        OutlinedTextField(
                            value = userInput,
                            onValueChange = { userInput = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            placeholder = { Text("Search monuments...") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            },
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                val filteredList = monumentList.filter { it.title.contains(userInput, ignoreCase = true) }
                filteredList.forEach {
                    item {
                        Card(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .fillMaxWidth(),
                            onClick = { navigateToDetailScreen(it.id.toInt()) },
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainer,
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 3.dp
                            ),
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Spacer(modifier = Modifier.width(12.dp))

                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = it.title,
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(0.4f)
                                    )

                                    if (it.description != null) {
                                        Text(
                                            text = it.description,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier
                                                .padding(start = 3.dp)
                                                .weight(0.6f)
                                        )
                                    }
                                }

                                IconButton(
                                    onClick = { selectedMonumentId = it.id.toInt(); showDialog = true },
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "Delete monument",
                                        tint = MaterialTheme.colorScheme.error
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        if (showDialog) {
            ModalBottomSheet(
                onDismissRequest = { showDialog = false; },
                sheetState = bottomSheetState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("¿Do you really want to delete this monument?")
                    Spacer(Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = {
                            showDialog = false
                        }) {
                            Text("No")
                        }
                        TextButton(onClick = {
                            showDialog = false
                            deleteMonument(selectedMonumentId)
                        }) {
                            Text("Yes")
                        }
                    }
                }
            }
        }
    }
}
