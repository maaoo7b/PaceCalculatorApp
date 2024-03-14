package com.maodev.pacecalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maodev.pacecalculatorapp.screen.MainScreen
import com.maodev.pacecalculatorapp.screen.MainScreenViewModel
import com.maodev.pacecalculatorapp.ui.theme.PaceCalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaceCalculatorAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val calculatorViewModel: MainScreenViewModel by viewModels()
                    RacePaceApp(calculatorViewModel)
                }
            }
        }
    }
}

@Composable
fun RacePaceApp(calculatorViewModel: MainScreenViewModel = viewModel()) {
    MainScreen(calculatorViewModel)
}
