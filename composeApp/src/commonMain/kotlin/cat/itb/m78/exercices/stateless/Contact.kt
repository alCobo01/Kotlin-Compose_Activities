package cat.itb.m78.exercices.stateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

@Composable
fun Contact(){
    data class Contact(val fullName: String, val email: String, val phone: String)
    val contact = Contact("Marta Casserres", "marta@example.com", "934578484")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.generatedFace),
            contentDescription = null,
            modifier = Modifier.size(150.dp).clip(CircleShape)
        )
        Text("Marta Caserras", fontSize = 2.em, fontWeight = FontWeight.Bold, modifier = Modifier
            .padding(top = 10.dp))

        Spacer(modifier = Modifier.size(20.dp))

        Card(modifier = Modifier
            ){
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp)) {
                Row() {
                    Icon(Icons.Default.Email, contentDescription = null)
                    Text(contact.email)
                }
                Row() {
                    Icon(Icons.Default.Phone, contentDescription = null)
                    Text(contact.phone)
                }
            }
        }
    }
}