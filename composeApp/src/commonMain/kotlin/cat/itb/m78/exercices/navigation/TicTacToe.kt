package cat.itb.m78.exercices.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

object GameDestination{
    @Serializable
    data object FirstScreen
    @Serializable
    data object GameScreen
    @Serializable
    data object FinalScreen
}

@Composable
fun TicTacToe(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = GameDestination.FirstScreen){
        composable<GameDestination.FirstScreen> {
            FirstScreen(
                navigateToGameScreen = { navController.navigate(GameDestination.GameScreen) }
            )
        }
        composable<GameDestination.GameScreen> {
            GameScreen(
                navigateToFinalScreen = { navController.navigate(GameDestination.FinalScreen) }
            )
        }
    }
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
fun GameScreen(navigateToFinalScreen: () -> Unit){
    var jugador by remember { mutableStateOf(false) }
    var matriu by remember { mutableStateOf(Array(3) { IntArray(3) }) }

    fun assignarValor(fila: Int, columna: Int){
        if (matriu[fila][columna] == 0) {
            matriu[fila][columna] = if (jugador) 1 else 2
            jugador = !jugador
        }
    }

    Column {
        Row {
            Button(onClick = { assignarValor(0, 0) }){
                Text("")
            }
        }
    }



}

@Composable
fun FinalScreen(){

}