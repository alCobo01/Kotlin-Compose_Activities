package cat.itb.m78.exercices.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import kotlinx.coroutines.launch
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.dice_2
import m78exercices.composeapp.generated.resources.dice_3
import m78exercices.composeapp.generated.resources.dice_4
import m78exercices.composeapp.generated.resources.dice_5
import m78exercices.composeapp.generated.resources.dice_6
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import kotlin.math.absoluteValue
import kotlin.random.Random

@Composable
fun DiceRoller(){
    val dice1 = remember { mutableStateOf(1) }
    val dice2 = remember { mutableStateOf(2) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

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
            Button( onClick = {
                dice1.value = chooseDice()
                dice2.value = chooseDice()
                if (dice1.value == 6 && dice2.value == 6){
                    scope.launch {
                        snackbarHostState.showSnackbar("Jackpot baby!!")
                    }
                }
            } ){ Text("Roll the dice!") }
            Row {
                Image(painter = painterResource(decideDice(dice1.value)), contentDescription = null)
                Image(painter = painterResource(decideDice(dice2.value)), contentDescription = null)
            }
            SnackbarHost(hostState = snackbarHostState)
        }
    }
}

fun chooseDice(): Int{
    return (5..6).random()
}

fun decideDice(dice: Int): DrawableResource {
    return when (dice) {
        1 -> Res.drawable.dice_1
        2 -> Res.drawable.dice_2
        3 -> Res.drawable.dice_3
        4 -> Res.drawable.dice_4
        5 -> Res.drawable.dice_5
        6 -> Res.drawable.dice_6
        else -> Res.drawable.dice_1
    }
}