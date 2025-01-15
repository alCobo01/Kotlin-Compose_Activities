package cat.itb.m78.exercices.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiceRoller(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(Res.drawable.tapestry),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Image(painter = painterResource(Res.drawable.title), contentDescription = null)
            Button( onClick = { ChooseDice() } ){ Text("Roll the dice!") }
            Row {
                Image(painter = painterResource(Res.drawable.dice_1), contentDescription = null)
            }
        }
    }

}

fun ChooseDice(){

}