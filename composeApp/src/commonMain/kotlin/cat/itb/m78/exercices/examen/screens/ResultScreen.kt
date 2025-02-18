package cat.itb.m78.exercices.examen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.itb.m78.exercices.examen.CalculatorViewModel
import cat.itb.m78.exercices.examen.brush
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Calculator_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun ResultatScreen(viewModel: CalculatorViewModel){
    ResultatScreenView(viewModel)
}

@Composable
fun ResultatScreenView(viewModel: CalculatorViewModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ){
        Text(
            text = "The final result is:",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = viewModel.savedNumber.toString(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Image(
            painter = painterResource(Res.drawable.Calculator_icon),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
    }
}