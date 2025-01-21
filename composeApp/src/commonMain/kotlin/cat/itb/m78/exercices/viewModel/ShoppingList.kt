package cat.itb.m78.exercices.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items

data class Product(val name: String, val amount: Int)

class ShoppingListViewModel : ViewModel() {
    var name = mutableStateOf("")
    var amount = mutableStateOf(0)
    var products = mutableStateOf(listOf<Product>())

    fun addProduct() {
        if (name.value.isNotEmpty() && amount.value > 0) {
            products.value += Product(name.value, amount.value)
            name.value = ""
            amount.value = 0
        }
    }
}


@Composable
fun ShoppingList(){
    val viewModel = viewModel { ShoppingListViewModel() }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                TextField(
                    value = viewModel.name.value,
                    onValueChange = { viewModel.name.value = it },
                    label = { Text("Name") }
                )
                TextField(
                    value = viewModel.amount.value.toString(),
                    onValueChange = { viewModel.amount.value = it.toIntOrNull() ?: 0  },
                    label = { Text("Amount") }
                )
                Button(
                    onClick = { viewModel.addProduct() },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(text = "Add product!", fontSize = 16.sp, color = Color.White)
                }
            }

        }
        LazyColumn(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            items(viewModel.products.value) { product ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(Color.Gray),
                ) {
                    Text(text = product.name, fontSize = 18.sp)
                    Text(text = product.amount.toString(), fontSize = 18.sp)
                }
            }
        }
    }
}