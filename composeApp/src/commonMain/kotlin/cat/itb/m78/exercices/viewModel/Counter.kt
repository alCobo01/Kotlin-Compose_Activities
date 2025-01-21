package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterViewModel : ViewModel() {
    val scoreTeam1 = mutableStateOf(0)
    val scoreTeam2 = mutableStateOf(0)

    fun incrementTeam1() {
        scoreTeam1.value++
    }

    fun incrementTeam2() {
        scoreTeam2.value++
    }
}

@Composable
fun CounterApp() {
    val viewModel = viewModel { CounterViewModel() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //equipo 1
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Team 1",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${viewModel.scoreTeam1.value}",
                        color = Color.White,
                        fontSize = 36.sp
                    )
                    Button(
                        onClick = { viewModel.incrementTeam1() },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(text = "Score!", fontSize = 16.sp, color = Color.White)
                    }
                }

                //equipo 2
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Team 2",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${viewModel.scoreTeam2.value}",
                        color = Color.White,
                        fontSize = 36.sp
                    )
                    Button(
                        onClick = { viewModel.incrementTeam2() },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9)),
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(text = "Score!", fontSize = 16.sp, color = Color.White)
                    }
                }
            }
        }
    }
}
