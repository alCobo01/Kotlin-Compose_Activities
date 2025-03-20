package cat.itb.m78.exercices.api.embassaments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmbassamentSecondScreen(navigateToFirstScreen: () -> Unit, viewModel: EmbassamentsViewModel){
    val selectedEmbassament = viewModel.selectedEmbassament.value
    EmbassamentSecondScreenArgument(navigateToFirstScreen, selectedEmbassament)
}

@Composable
fun EmbassamentSecondScreenArgument(navigateToFirstScreen: () -> Unit, selectedEmbassament: Embassaments){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Embassament seleccionat: ${selectedEmbassament.estacio}")
        Text("Dia: ${selectedEmbassament.dia}")
        Text("Nivell absolut: ${selectedEmbassament.nivellAbsolut}")
        Text("Percentatge de volum embassat: ${selectedEmbassament.percentatgeVolumEmbassat}%")
        Text("Volum embassat: ${selectedEmbassament.volumEmbassat}")

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = navigateToFirstScreen) {
            Text("Torna a la pantalla principal")
        }

    }
}