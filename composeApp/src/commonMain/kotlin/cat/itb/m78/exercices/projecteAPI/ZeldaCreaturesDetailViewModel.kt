package cat.itb.m78.exercices.projecteAPI

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZeldaCreaturesDetailViewModel(selectedCreatureName: String) : ViewModel() {
    private val dummyCreature = Creature("", "", "")
    var selectedCreature = mutableStateOf(dummyCreature)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            selectedCreature.value = ZeldaCreaturesAPI.find(selectedCreatureName)
        }
    }
}