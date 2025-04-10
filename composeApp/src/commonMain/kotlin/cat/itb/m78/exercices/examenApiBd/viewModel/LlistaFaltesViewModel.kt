package cat.itb.m78.exercices.examenApiBd.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.db.LlistaFaltesAlumnes
import cat.itb.m78.exercices.examenApiBd.Estudiant
import cat.itb.m78.exercices.examenApiBd.LlistaAPI
import cat.itb.m78.exercices.sqldelight.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class FaltaEstudiant(
    val nomEstudiant: String,
    val dataFalta: String
)

class LlistaFaltesViewModel : ViewModel() {
    private val faltesQueries = database.llistaFaltesAlumnesQueries

    private var llistaAlumnes = mutableStateOf<List<Estudiant>>(emptyList())
    private var llistaFaltesDB = mutableStateOf<List<LlistaFaltesAlumnes>>(emptyList())

    var llistaFaltes = mutableStateListOf<FaltaEstudiant>()

    init {
        viewModelScope.launch(Dispatchers.Default){
            llistaAlumnes.value = LlistaAPI.list()
            llistaFaltesDB.value = faltesQueries.selectAll().executeAsList()

            llistaFaltesDB.value.forEach { falta ->
                val dataPerGuardar = falta.data_
                llistaAlumnes.value.forEach { alumne ->
                    if (falta.idEstudiant.toInt() == alumne.id){
                        val faltaPerGuardar = FaltaEstudiant(
                            nomEstudiant = "${alumne.name} ${alumne.surnames}",
                            dataFalta = dataPerGuardar
                        )
                        llistaFaltes.add(faltaPerGuardar)
                    }
                }
            }
        }
    }
}