package cat.itb.m78.exercices.projecteMapsCamera.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.db.Monuments
import cat.itb.m78.exercices.sqldelight.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MapViewModel : ViewModel() {
    private val dbQueries = database.monumentsQueries

    var monumentsList = mutableStateOf<List<Monuments>>(emptyList())

    init {
        viewModelScope.launch(Dispatchers.Default) {
            monumentsList.value = dbQueries.selectAll().executeAsList()
        }
    }
}