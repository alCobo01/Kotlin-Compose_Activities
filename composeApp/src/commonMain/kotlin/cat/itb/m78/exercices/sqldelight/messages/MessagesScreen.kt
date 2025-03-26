package cat.itb.m78.exercices.sqldelight.messages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Card
import cat.itb.m78.exercices.db.Messages

@Composable
fun MessagesScreen() {
    val viewModel = viewModel { MessagesViewModel() }
    MessagesScreenArguments(viewModel.listMessages.value, viewModel::insertMessage, viewModel::deleteMessages)
}

@Composable
fun MessagesScreenArguments(listMessages: List<Messages>, insertToDB: (String) -> Unit,
                            deleteFromDB: () -> Unit){
    var message by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = message,
            onValueChange = { message = it }
        )

        Button(onClick = {
            insertToDB(message)
            message = ""
        }) {
            Text("Add")
        }
        Button(onClick = {
            deleteFromDB()
            message = ""
        }) {
            Text("Delete all messages")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            itemsIndexed(listMessages) { _, message ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = message.text)
                    }
                }
            }
        }
    }
}

