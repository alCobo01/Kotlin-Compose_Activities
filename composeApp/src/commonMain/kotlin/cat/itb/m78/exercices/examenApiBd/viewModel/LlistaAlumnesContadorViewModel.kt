package cat.itb.m78.exercices.examenApiBd.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.db.LlistaFaltesAlumnes
import cat.itb.m78.exercices.examenApiBd.Estudiant
import cat.itb.m78.exercices.examenApiBd.LlistaAPI
import cat.itb.m78.exercices.sqldelight.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class LlistaAlumnesContadorViewModel : ViewModel(){
    private val faltesQueries = database.llistaFaltesAlumnesQueries

    private var llistaFaltesDB = mutableStateOf<List<LlistaFaltesAlumnes>>(emptyList())
    var llistaAlumnes = mutableStateOf<List<Estudiant>>(emptyList())
    var text = mutableStateOf("A quin alumne vols posar falta?")

    init {
        viewModelScope.launch(Dispatchers.Default){
            llistaAlumnes.value = LlistaAPI.list()
            llistaFaltesDB.value = faltesQueries.selectAll().executeAsList()
        }
    }

    fun posarFalta(alumne: Estudiant){
        faltesQueries.insert(alumne.id.toLong(), Clock.System.now().toString())
        text.value = "Falta posada a l'alumne ${alumne.name} ${alumne.surnames}"

    }

    fun contarFaltes(idAlumne: Int) : Int{
        val faltes = mutableStateOf(0)
        llistaFaltesDB.value.forEach {
            if (it.idEstudiant.toInt() == idAlumne) faltes.value++
        }

        return faltes.value
    }
}