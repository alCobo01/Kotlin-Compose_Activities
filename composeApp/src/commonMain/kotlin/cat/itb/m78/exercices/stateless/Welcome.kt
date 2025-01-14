package cat.itb.m78.exercices.stateless

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun Welcome(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome!", color = Color.White, fontSize = 2.em)
        Text("Start learning now", color = Color.White, modifier = Modifier
            .padding(bottom = 50.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue)
        ) { Text("Login") }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue)
        ) { Text("Register") }
    }
}