package cat.itb.m78.exercices.api.embassaments

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmbassamentDetailViewModel(name: String) : ViewModel() {
    private val embDummy = Embassaments("", "", 0.0, 0.0, 0.0)
    var selectedEmbassament = mutableStateOf<List<Embassaments>>(emptyList())

    init {
        viewModelScope.launch(Dispatchers.Default) {
            selectedEmbassament.value = MyApi.find(name)
        }
    }
}