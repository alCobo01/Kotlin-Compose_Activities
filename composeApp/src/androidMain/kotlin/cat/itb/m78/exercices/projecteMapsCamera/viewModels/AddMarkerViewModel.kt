package cat.itb.m78.exercices.projecteMapsCamera.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import cat.itb.m78.exercices.sqldelight.database
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.switchMap
import cat.itb.m78.exercices.projecteMapsCamera.DTOs.InsertMarker

const val PHOTO_URI_KEY = "photoUri"

class AddMarkerViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel(){
    var showDialog by mutableStateOf(false)
    var showTitleErrorDialog by mutableStateOf(false)
    val photoUri = savedStateHandle.getStateFlow<String?>(PHOTO_URI_KEY, null)

    private val dbQueries = database.monumentsQueries

    fun addMarker(marker : InsertMarker){
        dbQueries.insert(
            marker.latitude,
            marker.longitude,
            marker.title,
            marker.description,
            marker.imageUri
        )
    }



}