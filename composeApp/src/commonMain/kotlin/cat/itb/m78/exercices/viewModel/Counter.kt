package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterViewModel : ViewModel() {
    val scoreTeam1 = mutableStateOf(0)
    val scoreTeam2 = mutableStateOf(0)
}

@Composable
fun CounterApp(){
    val viewModel = viewModel { CounterViewModel() }

    Box(modifier = Modifier.fillMaxSize().background(color = Color.Green)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Text(viewModel.scoreTeam1.value)
            }
        }
    }
}
