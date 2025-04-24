package cat.itb.m78.exercices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cat.itb.m78.exercices.camera.Camera
import cat.itb.m78.exercices.maps.MapsScreen
import cat.itb.m78.exercices.projecteMapsCamera.MapsAndCamera

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MapsAndCamera() }
    }
}

@Preview
@Composable
fun AppPreview() { Camera() }
