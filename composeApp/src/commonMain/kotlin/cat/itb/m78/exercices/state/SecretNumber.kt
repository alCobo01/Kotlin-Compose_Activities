package cat.itb.m78.exercices.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SecretNumber(){
    var inputUser by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Endevina el número secret")
        TextField(
            value = inputUser,
            onValueChange = {inputUser = it}
        )
        Button(
            onClick = {
                val number = inputUser.toIntOrNull()
                if (number == null){
                    message = "Write a number"
                } else {
                    when (validate(number)){
                        0 -> message = "You have guessed the number!"
                        1 -> message = "THe number is bigger than the secret number!"
                        2 -> message = "The number is smaller than the secret number!"
                    }
                }

            }
        ){
            Text("Validate number")
        }
    }
}

fun validate(number: Int): Int {
    val secretNumber = 89
    if (number == secretNumber) return 0
    else if (number > secretNumber) return 1
    else return 2
}