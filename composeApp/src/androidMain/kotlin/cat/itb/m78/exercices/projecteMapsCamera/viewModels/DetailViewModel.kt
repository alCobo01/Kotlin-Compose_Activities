package cat.itb.m78.exercices.projecteMapsCamera.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cat.itb.m78.exercices.db.Monuments
import cat.itb.m78.exercices.sqldelight.database

class DetailViewModel(monumentId: Int) : ViewModel() {
    private val dbQueries = database.monumentsQueries
    private val dummyMonument = Monuments(0, 0.0, 0.0, "", "", "")

    var monument = mutableStateOf(dummyMonument)

    init {
        try {
            val loadedMonument = dbQueries.selectById(monumentId.toLong()).executeAsOne()
            monument.value = loadedMonument

            Log.d("DetailViewModel", "Loaded monument: $monumentId")
            Log.d("DetailViewModel", "Image URI: ${loadedMonument.imageUri}")
            if (loadedMonument.imageUri.isNullOrEmpty()) {
                Log.w("DetailViewModel", "Monument has empty image URI")
            }
        } catch (e: Exception) {
            Log.e("DetailViewModel", "Error loading monument: ${e.message}", e)
        }
    }
}
