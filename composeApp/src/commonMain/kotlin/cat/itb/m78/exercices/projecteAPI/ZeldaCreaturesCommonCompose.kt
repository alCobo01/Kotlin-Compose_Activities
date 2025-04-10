package cat.itb.m78.exercices.projecteAPI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

val brush = Brush.linearGradient(listOf(Color(0xFF506FE6), Color(0xFF50E6D9)))

@Composable
fun ContentLoading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TitleText("Loading content...")
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 8.dp,
            modifier = Modifier.size(96.dp)
        )
    }
}

@Composable
fun ThreeRowCard(navigateToDetailScreen: (Int) -> Unit, rowItems: List<Creature>) {
    Row {
        for (it in rowItems) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                onClick = { navigateToDetailScreen(it.id) },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CardText(it.name)
                    }

                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        modifier = Modifier
                            .size(210.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}

@Composable
fun TwoOrOneRowCard(navigateToDetailScreen: (Int) -> Unit, rowItems: List<Creature>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        for (it in rowItems) {
            Card(
                modifier = Modifier
                    .width(500.dp)
                    .padding(16.dp),
                onClick = { navigateToDetailScreen(it.id) },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CardText(it.name)
                    }
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        modifier = Modifier
                            .width(210.dp)
                            .height(210.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                    )
                }
            }
        }
    }
}

@Composable
fun StyledTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = "Search a creature!",
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        },
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.4f)
            )
        ,
        shape = RoundedCornerShape(16.dp),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
    )
}

@Composable
fun TitleText(text: String){
    Spacer(modifier = Modifier.height(30.dp))

    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CardText(text: String){
    Text(
        text = text.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
        style = MaterialTheme.typography.bodyLarge.copy(
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        ),
        textAlign = TextAlign.Center
    )
}
