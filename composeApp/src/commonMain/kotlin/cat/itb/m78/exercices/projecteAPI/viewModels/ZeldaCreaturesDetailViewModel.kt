package cat.itb.m78.exercices.projecteAPI.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.ZeldaCreaturesAPI
import cat.itb.m78.exercices.sqldelight.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZeldaCreaturesDetailViewModel(selectedCreatureName: Int) : ViewModel() {
    private val creaturesQueries = database.zeldaCreaturesQueries

    private val dummyCreature = Creature(0, "", "", "")
    var selectedCreature = mutableStateOf(dummyCreature)
    var isLiked = mutableStateOf(false)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            selectedCreature.value = ZeldaCreaturesAPI.find(selectedCreatureName)
            isLiked.value = isFav(selectedCreature.value.id)
        }
    }

    fun changeFavState(creatureId: Int){
        if (isFav(creatureId)){
            creaturesQueries.delete(creatureId.toLong())
        } else {
            creaturesQueries.insert(creatureId.toLong())
        }
        isLiked.value = !isLiked.value
    }

    private fun isFav(creatureId: Int): Boolean {
        val isFav = creaturesQueries.selectAll().executeAsList()
        return creatureId.toLong() in isFav
    }
}