package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OthelloBoard(){
    Column {
        repeat(8) { row ->
            Row {
                repeat(8) { column ->
                    OthelloCell(row, column)
                }
            }
        }
    }
}

@Composable
fun OthelloCell(row: Int, column: Int) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .border(1.dp, Color.Black)
            .background(Color.Green)
    ) {
        // Aquí puedes añadir la lógica para mostrar fichas blancas o negras
    }
}
