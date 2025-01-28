package cat.itb.m78.exercices.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

object GameDestination{
    @Serializable
    data object FirstScreen
    @Serializable
    data object GameScreen
}


@Composable
fun TicTacToe(){

}

@Composable
fun FirstScreen(navigateToGameScreen: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Benvinguts al Tic Tac Toe!")
        Button(onClick = navigateToGameScreen){ Text("Juguem!") }
    }
}

@Composable
fun GameScreen(){

}

@Composable
fun FinalScreen(){

}