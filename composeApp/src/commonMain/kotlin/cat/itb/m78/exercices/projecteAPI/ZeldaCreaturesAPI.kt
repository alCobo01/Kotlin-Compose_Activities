package cat.itb.m78.exercices.projecteAPI

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class CreatureListResponse(
    @SerialName("data") val data: List<Creature>
)

@Serializable
data class CreatureSingleResponse(
    @SerialName("data") val data: Creature
)

@Serializable
data class Creature(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("image") val image: String
)

object ZeldaCreaturesAPI {
    private const val url = "https://botw-compendium.herokuapp.com/api/v3/compendium"
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun list() : List<Creature> {
        return client.get("$url/category/creatures").body<CreatureListResponse>().data
    }

    suspend fun find(id: Int) : Creature {
        return client.get("$url/entry/$id").body<CreatureSingleResponse>().data
    }
}