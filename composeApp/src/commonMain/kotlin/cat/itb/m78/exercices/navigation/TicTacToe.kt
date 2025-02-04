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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
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

class TicViewModel : ViewModel(){
    var jugador by mutableStateOf(false)
    var matriuValors by mutableStateOf(Array(3) { IntArray(3) {0} })
    var buttonText by mutableStateOf(Array(3) { Array(3) {""} })
    var winnerMessage by mutableStateOf("")

    fun jugada(fila: Int, columna: Int){
        if (matriuValors[fila][columna] == 0) {
            matriuValors[fila][columna] = if (jugador) 1 else 2
            buttonText[fila][columna] = if (jugador) "X" else "O"
            jugador = !jugador
        }
    }

    fun checkWinner(): Int {
        for (i in 0..2) {
            if (matriuValors[i][0] != 0 &&
                matriuValors[i][0] == matriuValors[i][1] &&
                matriuValors[i][1] == matriuValors[i][2]
            ) {
                winnerMessage = if (matriuValors[i][0] == 1) "X wins!" else "O wins!"
                return matriuValors[i][0]
            }
        }

        for (j in 0..2) {
            if (matriuValors[0][j] != 0 &&
                matriuValors[0][j] == matriuValors[1][j] &&
                matriuValors[1][j] == matriuValors[2][j]
            ) {
                winnerMessage = if (matriuValors[0][j] == 1) "X wins!" else "O wins!"
                return matriuValors[0][j]
            }
        }

        if (matriuValors[0][0] != 0 &&
            matriuValors[0][0] == matriuValors[1][1] &&
            matriuValors[1][1] == matriuValors[2][2]
        ) {
            winnerMessage = if (matriuValors[0][0] == 1) "X wins!" else "O wins!"
            return matriuValors[0][0]
        }
        if (matriuValors[0][2] != 0 &&
            matriuValors[0][2] == matriuValors[1][1] &&
            matriuValors[1][1] == matriuValors[2][0]
        ) {
            winnerMessage = if (matriuValors[0][2] == 1) "X wins!" else "O wins!"
            return matriuValors[0][2]
        }

        if (matriuValors.all { row -> row.all { it != 0 } }) {
            winnerMessage = "Draw"
            return -1
        }
        return 0 // El juego continúa
    }
}


@Composable
fun TicTacToe(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = GameDestination.FirstScreen){
        composable<GameDestination.FirstScreen> {
            FirstScreen(
                navigateToGameScreen = {
                    navController.navigate(GameDestination.GameScreen) }
            )
        }
        composable<GameDestination.GameScreen> {
            val viewModel: TicViewModel = viewModel{ TicViewModel() }
            GameScreen(
                navigateToFinalScreen = {
                    navController.navigate(GameDestination.FinalScreen) },
                viewModel = viewModel
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
        Button(onClick = navigateToGameScreen){ Text("Juguem!")
            println("hola")}
    }
}

@Composable
fun GameScreen(viewModel: TicViewModel, navigateToFinalScreen: () -> Unit){
    val buttonText by remember { mutableStateOf(viewModel.buttonText) }

    Column {
        for (fila in 0..2){
            Row {
                for (columna in 0..2){
                    Button(
                        onClick = { viewModel.jugada(fila, columna) }
                    ){
                        Text(buttonText[fila][columna])
                }
            }
        }
        }
    }



}

@Composable
fun FinalScreen(){

}