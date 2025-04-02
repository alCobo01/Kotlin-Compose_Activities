package cat.itb.m78.exercices.projecteAPI.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.ZeldaCreaturesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZeldaCreaturesDetailViewModel(selectedCreatureName: Int) : ViewModel() {
    private val dummyCreature = Creature(0, "", "", "")
    var selectedCreature = mutableStateOf(dummyCreature)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            selectedCreature.value = ZeldaCreaturesAPI.find(selectedCreatureName)
        }
    }
}