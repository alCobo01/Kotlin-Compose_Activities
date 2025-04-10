package cat.itb.m78.exercices.examenApiBd.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.examenApiBd.Estudiant
import cat.itb.m78.exercices.examenApiBd.LlistaAPI
import cat.itb.m78.exercices.sqldelight.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class LlistaAlumnesViewModel : ViewModel(){
    private val llistaQueries = database.llistaFaltesAlumnesQueries

    var llistaAlumnes = mutableStateOf<List<Estudiant>>(emptyList())
    var text = mutableStateOf("A quin alumne vols posar falta?")

    init {
        viewModelScope.launch(Dispatchers.Default){
            llistaAlumnes.value = LlistaAPI.list()
        }
    }

    fun posarFalta(alumne: Estudiant){
        llistaQueries.insert(alumne.id.toLong(), Clock.System.now().toString())
        text.value = "Falta posada a l'alumne ${alumne.name} ${alumne.surnames}"

    }
}