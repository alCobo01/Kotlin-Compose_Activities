package cat.itb.m78.exercices.trivial.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.trivial.brush
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

class GameViewModel(val totalRounds: Int) : ViewModel(){
    var roundText by mutableStateOf("")
    var score by mutableStateOf(0)
    var mostrarResultat by mutableStateOf(false)
    var currentQuestion by mutableStateOf<Question?>(null)
    var gameFinished by mutableStateOf(false)
    var currentRound by mutableStateOf(1)

    private val questions = listOf(
        Question(
            text = "Quina és la capital del Japó?",
            options = listOf("Tòquio", "Osaka", "Kyoto", "Hiroshima"),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Quin planeta és conegut com el Planeta Vermell?",
            options = listOf("Venus", "Mart", "Júpiter", "Saturn"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Qui va escriure 'Cent anys de solitud'?",
            options = listOf("Mario Vargas Llosa", "Gabriel García Márquez", "Jorge Luis Borges", "Isabel Allende"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "En quin any va començar la Segona Guerra Mundial?",
            options = listOf("1914", "1939", "1945", "1929"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin és l'element químic amb el símbol O?",
            options = listOf("Or", "Osmio", "Oxigen", "Oganeson"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Qui va pintar la Mona Lisa?",
            options = listOf("Leonardo da Vinci", "Miguel Àngel", "Vincent van Gogh", "Pablo Picasso"),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Quin és el riu més llarg del món?",
            options = listOf("Nil", "Amazonas", "Yangtsé", "Mississippi"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin òrgan del cos humà filtra la sang?",
            options = listOf("Pulmons", "Ficat", "Ronyons", "Cor"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Quants colors té l’arc de Sant Martí?",
            options = listOf("6", "7", "8", "9"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin és l’oceà més gran del món?",
            options = listOf("Atlàntic", "Pacífic", "Índic", "Àrtic"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin país va guanyar la Copa del Món de Futbol l'any 2018?",
            options = listOf("Brasil", "Alemanya", "França", "Argentina"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Quin instrument s'utilitza per mesurar la pressió atmosfèrica?",
            options = listOf("Baròmetre", "Higròmetre", "Termòmetre", "Anemòmetre"),
            correctAnswerIndex = 0
        ),
        Question(
            text = "En quin continent es troba Egipte?",
            options = listOf("Àsia", "Àfrica", "Europa", "Amèrica"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quina fórmula química representa l'aigua?",
            options = listOf("H2O", "CO2", "O2", "CH4"),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Quin gas és essencial per a la respiració humana?",
            options = listOf("Diòxid de carboni", "Oxigen", "Nitrògen", "Hidrogen"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "En quin país es troba la Torre Eiffel?",
            options = listOf("Itàlia", "França", "Espanya", "Alemanya"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quina és la llengua més parlada al món?",
            options = listOf("Anglès", "Mandarí", "Espanyol", "Hindi"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin animal és conegut com el rei de la selva?",
            options = listOf("Elefant", "Lleó", "Tigre", "Girafa"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin número romà representa el 100?",
            options = listOf("L", "C", "D", "M"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin país és famós pels tulipes i els molins de vent?",
            options = listOf("Dinamarca", "Països Baixos", "Suïssa", "Bèlgica"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quina substància dóna color verd a les plantes?",
            options = listOf("Clorofil·la", "Hemoglobina", "Cel·lulosa", "Carotenoides"),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Quina és la muntanya més alta del món?",
            options = listOf("K2", "Kangchenjunga", "Everest", "Lhotse"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Quin país té la forma d'una bota?",
            options = listOf("Espanya", "Itàlia", "França", "Portugal"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quina ciutat és coneguda com la 'Gran Poma'?",
            options = listOf("Los Angeles", "Chicago", "Nova York", "Miami"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Quin invent va crear Thomas Edison?",
            options = listOf("El telèfon", "La bombeta elèctrica", "El cotxe", "La ràdio"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin esport és anomenat 'el rei dels esports'?",
            options = listOf("Futbol", "Bàsquet", "Voleibol", "Tenis"),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Quin planeta és el més gran del sistema solar?",
            options = listOf("Mart", "Júpiter", "Saturn", "Urà"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin científic va desenvolupar la teoria de la relativitat?",
            options = listOf("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin és l'estat físic de l'aigua a 0ºC?",
            options = listOf("Líquid", "Sòlid", "Gas", "Plasmàtic"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Quin element químic té el símbol 'Fe'?",
            options = listOf("Plom", "Ferro", "Argent", "Coure"),
            correctAnswerIndex = 1
        )
    )

    fun randomQuestion(): Question {
        return questions.random()
    }

    fun checkQuestion(userAnswer: Int, navigateToResultScreen: () -> Unit){
        if (!gameFinished) {
            if (userAnswer == currentQuestion?.correctAnswerIndex) {
                roundText = "Resposta correcta!"
                score++
            } else {
                roundText = "Resposta incorrecta..."
            }
            mostrarResultat = true
            viewModelScope.launch {
                delay(5000)
                mostrarResultat = false
                if (score >= totalRounds) {
                    gameFinished = true
                    navigateToResultScreen()
                } else {
                    currentQuestion = randomQuestion()
                    currentRound++
                }
            }
        }
    }
}

@Composable
fun GameScreen(totalRounds: Int, navigateToResultScreen: () -> Unit){
    val viewModel: GameViewModel = viewModel { GameViewModel(totalRounds) }
    var currentQuestion by remember { mutableStateOf<Question?>(null) }

    LaunchedEffect(Unit){
        currentQuestion = viewModel.randomQuestion()
    }

    GameScreenView(viewModel, currentQuestion, navigateToResultScreen)
}

@Composable
fun GameScreenView(viewModel: GameViewModel, currentQuestion : Question?, navigateToResultScreen: () -> Unit){
    LaunchedEffect(Unit) {
        if (viewModel.gameFinished) {
            navigateToResultScreen()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        if (viewModel.mostrarResultat) Text(viewModel.roundText)

        if (currentQuestion != null) {
            Text(currentQuestion.text)
            Row {
                Button(onClick = { viewModel.checkQuestion(0, navigateToResultScreen) } ){
                    Text(currentQuestion.options[0])}
                Button(onClick = { viewModel.checkQuestion(1, navigateToResultScreen) } ){
                    Text(currentQuestion.options[1])}
            }
            Row {
                Button(onClick = { viewModel.checkQuestion(2, navigateToResultScreen) } ){
                    Text(currentQuestion.options[2])}
                Button(onClick = { viewModel.checkQuestion(3, navigateToResultScreen) } ){
                    Text(currentQuestion.options[3])}
            }

            Text("Ronda ${viewModel.currentRound} de ${viewModel.totalRounds}")
            Text("Punts: ${viewModel.score}")
        }

    }
}