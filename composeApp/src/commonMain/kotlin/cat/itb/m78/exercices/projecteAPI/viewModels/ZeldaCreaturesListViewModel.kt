package cat.itb.m78.exercices.projecteAPI.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.ZeldaCreaturesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZeldaCreaturesListViewModel : ViewModel() {
        var creaturesList = mutableStateOf<List<Creature>>(emptyList())

        init {
            viewModelScope.launch(Dispatchers.Default) {
                creaturesList.value = ZeldaCreaturesAPI.list()
            }
        }
}

