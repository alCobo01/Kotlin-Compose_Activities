package cat.itb.m78.exercices.api.embassaments

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmbassamentFirstScreen(navigateToSecondScreen: () -> Unit, viewModel: EmbassamentsViewModel){
    EmbassamentFirstScreenArgument(navigateToSecondScreen, viewModel)
}

@Composable
fun EmbassamentFirstScreenArgument(navigateToSecondScreen: () -> Unit, viewModel: EmbassamentsViewModel){
    LazyColumn {
        viewModel.embassamentsList.value.forEach {
            item {
                Card(
                    modifier = Modifier.padding(10.dp).fillMaxWidth()
                ) {
                    Button(onClick = { viewModel.selectedEmbassament.value = it; navigateToSecondScreen() }) {
                        Text(text = it.estacio)
                    }
                }
            }
        }

    }
}
