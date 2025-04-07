package cat.itb.m78.exercices.projecteAPI.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.projecteAPI.Creature
import cat.itb.m78.exercices.projecteAPI.ZeldaCreaturesAPI
import cat.itb.m78.exercices.sqldelight.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZeldaCreaturesFavoritesViewModel : ViewModel() {
    private val creaturesQueries = database.zeldaCreaturesQueries

    var likedCreatures = mutableStateOf<List<Creature>>(emptyList())
    var isLoading by mutableStateOf(true)

    init {
        viewModelScope.launch(Dispatchers.Default){
            val idsLikedCreatures = creaturesQueries.selectAll().executeAsList()

            val creatures = idsLikedCreatures.map { id ->
                ZeldaCreaturesAPI.find(id.toInt())
            }

            likedCreatures.value = creatures
            isLoading = false
        }
    }


}