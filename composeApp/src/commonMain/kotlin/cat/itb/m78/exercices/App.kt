package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.state.DiceRoller
import cat.itb.m78.exercices.state.GoodMorningAndNight
import cat.itb.m78.exercices.state.SayHelloScreen
import cat.itb.m78.exercices.state.SecretNumber
import cat.itb.m78.exercices.stateless.Contact
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    DiceRoller()
}
