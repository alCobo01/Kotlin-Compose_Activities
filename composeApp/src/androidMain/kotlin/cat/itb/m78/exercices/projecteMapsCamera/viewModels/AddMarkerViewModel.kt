package cat.itb.m78.exercices.projecteMapsCamera.viewModels

import androidx.lifecycle.ViewModel
import cat.itb.m78.exercices.projecteMapsCamera.DTOs.InsertMarker
import cat.itb.m78.exercices.sqldelight.database

class AddMarkerViewModel : ViewModel(){
    private val _marker = mutableStateOf(InsertMarker(0.0, 0.0, "", "", ""))
    val marker: State<InsertMarker> = _marker

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