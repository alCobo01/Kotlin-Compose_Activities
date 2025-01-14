package cat.itb.m78.exercices.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

@Composable
fun GoodMorningAndNight() {
    var text = remember { mutableStateOf("Good... who knows?") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text.value)
        Button(onClick = { text.value = "Good morning!" }) { Text("Morning") }
        Button(onClick = { text.value = "Good night!" }) { Text("Night") }
    }

}

