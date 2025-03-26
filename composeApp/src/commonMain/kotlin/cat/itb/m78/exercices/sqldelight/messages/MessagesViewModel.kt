package cat.itb.m78.exercices.sqldelight.messages

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cat.itb.m78.exercices.db.Messages
import cat.itb.m78.exercices.sqldelight.database

class MessagesViewModel : ViewModel() {
    private val messageQueries = database.messagesQueries
    val listMessages = mutableStateOf(messageQueries.selectAll().executeAsList())

    private fun getAllMessages() = messageQueries.selectAll().executeAsList()

    fun insertMessage(message: String) { messageQueries.insert(message); listMessages.value = getAllMessages() }

    fun deleteMessages() { messageQueries.deleteAll(); listMessages.value = getAllMessages() }
}
