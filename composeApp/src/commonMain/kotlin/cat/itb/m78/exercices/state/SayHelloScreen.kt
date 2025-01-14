package cat.itb.m78.exercices.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SayHelloScreen(){
    var message by remember { mutableStateOf("") }
    var inputUser = remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column {
        TextField(
            inputUser.value,
            onValueChange = {inputUser.value = it}
        )
        Button(
            onClick = {
                message = "Hello " + inputUser.value + "!"
                showDialog = true
            }
        ){
            Text("Hello... but who?")
        }

        if(showDialog)
            AlertDialog(
                onDismissRequest={showDialog = false},
                confirmButton={},
                text = {
                    Text(message)
                }
            )
    }

}

