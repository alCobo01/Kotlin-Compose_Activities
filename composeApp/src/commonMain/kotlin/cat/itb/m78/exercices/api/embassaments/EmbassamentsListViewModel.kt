package cat.itb.m78.exercices.api.embassaments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import androidx.compose.runtime.mutableStateOf

object MyApi {
    private const val URL = "https://analisi.transparenciacatalunya.cat/resource/gn9e-3qhr.json"
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun list() = client.get(URL).body<List<Embassaments>>()

    suspend fun find(name: String) = client.get("$URL?estaci=$name").body<List<Embassaments>>()
}

@Serializable
data class Embassaments(
    @SerialName("dia") val dia: String,
    @SerialName("estaci") val estacio: String,
    @SerialName("nivell_absolut") val nivellAbsolut: Double,
    @SerialName("percentatge_volum_embassat") val percentatgeVolumEmbassat: Double,
    @SerialName("volum_embassat") val volumEmbassat: Double
)

class EmbassamentListViewModel : ViewModel() {
    private val embDummy = Embassaments("", "", 0.0, 0.0, 0.0)

    var embassamentsList = mutableStateOf<List<Embassaments>>(emptyList())
    var selectedEmbassament = mutableStateOf(embDummy)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            embassamentsList.value = MyApi.list()
        }
    }
}