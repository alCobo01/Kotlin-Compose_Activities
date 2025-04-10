package cat.itb.m78.exercices.examenApiBd

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Estudiant(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("surnames") val surnames: String,
    @SerialName("email") val email: String,
    @SerialName("photo_link") val photo: String
)

object LlistaAPI {
    private const val url = "https://fp.mateuyabar.com/DAM-M78/composeP2/exam/students.json"
    private val client = HttpClient(){
        install(ContentNegotiation){
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun list() : List<Estudiant> {
        return client.get(url).body<List<Estudiant>>()
    }
}