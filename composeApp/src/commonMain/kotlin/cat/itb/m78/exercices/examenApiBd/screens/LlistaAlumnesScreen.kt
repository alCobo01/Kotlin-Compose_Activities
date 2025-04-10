package cat.itb.m78.exercices.examenApiBd.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.examenApiBd.Estudiant
import cat.itb.m78.exercices.examenApiBd.viewModel.LlistaAlumnesViewModel
import coil3.compose.AsyncImage

@Composable
fun LlistaAlumnesScreen(){
    val viewModel = viewModel { LlistaAlumnesViewModel() }
    val llistaAlumnes : MutableState<List<Estudiant>> = viewModel.llistaAlumnes
    val textInformatiu = viewModel.text

    LlistaAlumnesScreenArguments(llistaAlumnes.value, textInformatiu.value ,viewModel)
}

@Composable
fun LlistaAlumnesScreenArguments(llistaAlumnes: List<Estudiant>, textInformatiu: String, viewModel: LlistaAlumnesViewModel){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (llistaAlumnes.isEmpty()){
            CircularProgressIndicator()
            Text("Recuperant la llista d'alumnes...")
        } else {
            Spacer(Modifier.height(16.dp))

            Text(textInformatiu)

            Spacer(Modifier.height(16.dp))

            LazyColumn {
                val rows = llistaAlumnes.chunked(3)
                rows.forEach { rowItems ->
                    if (rowItems.size == 3){
                        item {
                            Row {
                                for (it in rowItems){
                                    Card(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .weight(1f),
                                        onClick = { viewModel.posarFalta(it) },
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))

                                    ) {
                                        Row(
                                            modifier = Modifier.padding(16.dp).fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            ) {
                                                Text(text = "${it.name} ${it.surnames}" )
                                                Text(text = it.email)
                                            }
                                            AsyncImage(
                                                model = it.photo,
                                                contentDescription = it.name,
                                                modifier = Modifier
                                                    .width(175.dp)
                                                    .height(175.dp)
                                                    .clip(shape = RoundedCornerShape(16.dp))
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        item {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                            ) {
                                for (it in rowItems) {
                                    Card(
                                        modifier = Modifier.width(500.dp),
                                        onClick = { viewModel.posarFalta(it) },
                                        colors = CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(16.dp).fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            ) {
                                                Text(text = "${it.name} ${it.surnames}" )
                                                Text(text = it.email)
                                            }
                                            AsyncImage(
                                                model = it.photo,
                                                contentDescription = it.name,
                                                modifier = Modifier
                                                    .width(175.dp)
                                                    .height(175.dp)
                                                    .clip(shape = RoundedCornerShape(16.dp))
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}