package cat.itb.m78.exercices.projecteAPI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val brush = Brush.linearGradient(listOf(Color(0xFF506FE6), Color(0xFF50E6D9)))

@Composable
fun ContentLoading(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Loading content...")
        CircularProgressIndicator()
    }
}

@Composable
fun ImageLoading(){
    Text("Loading image...")
    CircularProgressIndicator()
}