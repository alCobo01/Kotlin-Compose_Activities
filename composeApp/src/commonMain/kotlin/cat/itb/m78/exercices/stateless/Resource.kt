package cat.itb.m78.exercices.stateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import m78exercices.composeapp.generated.resources.resource_string_example
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun Resource(){
    Column(modifier = Modifier
        .width(300.dp)
        .height(500.dp)
    ) {
        Text(stringResource(Res.string.resource_string_example))
        Image(
            painter = painterResource(Res.drawable.generatedFace),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}