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
import androidx.compose.foundation.lazy.itemsIndexed
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
import cat.itb.m78.exercices.db.LlistaFaltesAlumnes
import cat.itb.m78.exercices.examenApiBd.Estudiant
import cat.itb.m78.exercices.examenApiBd.viewModel.FaltaEstudiant
import cat.itb.m78.exercices.examenApiBd.viewModel.LlistaAlumnesViewModel
import cat.itb.m78.exercices.examenApiBd.viewModel.LlistaFaltesViewModel
import coil3.compose.AsyncImage

@Composable
fun LlistaFaltesScreen(){
    val viewModel = viewModel { LlistaFaltesViewModel() }
    val llistaFaltes : MutableList<FaltaEstudiant> = viewModel.llistaFaltes

    LlistaFaltesScreenArguments(llistaFaltes)
}

@Composable
fun LlistaFaltesScreenArguments(llistaFaltes: List<FaltaEstudiant>){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (llistaFaltes.isEmpty()){
            CircularProgressIndicator()
            Text("Recuperant la llista de faltes...")
        } else {
            Spacer(Modifier.height(16.dp))

            Text("Faltes d'alumnes")

            Spacer(Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.width(550.dp)
            ) {
                itemsIndexed(llistaFaltes) {_, falta ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "${falta.nomEstudiant} ${falta.dataFalta}")
                        }
                    }
                }
            }
        }
    }
}