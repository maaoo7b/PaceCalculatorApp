package com.maodev.pacecalculatorapp.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.maodev.pacecalculatorapp.components.CalculatorButton
import com.maodev.pacecalculatorapp.components.CalculatorLabel
import com.maodev.pacecalculatorapp.components.CalculatorTextField


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(calculatorViewModel: MainScreenViewModel) {
    Scaffold(
        topBar = {
            MyTopAppBar()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            MainContent(calculatorViewModel)
        }
    }
}

@Composable
fun MainContent(calculatorViewModel: MainScreenViewModel) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0XFFF8FBF8)),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(25.dp)
    ) {
        CardFields(calculatorViewModel)
    }

}

@Composable
fun CardFields(calculatorViewModel: MainScreenViewModel) {
    var kms by remember {
        mutableStateOf("")
    }
    var meters by remember {
        mutableStateOf("")
    }
    var hours by remember {
        mutableStateOf("")
    }
    var minutes by remember {
        mutableStateOf("")
    }
    var seconds by remember {
        mutableStateOf("")
    }
    var minPace by remember {
        mutableStateOf("")
    }
    var segPace by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        CalculatorLabel(label = "DISTANCE", fontWeight = FontWeight.Bold, fontSize = 20)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = kms,
                label = "Kms",
                enabled = true,
                onTextChange = { kms = it })
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = meters,
                label = "Meters",
                enabled = true,
                onTextChange = { meters = it })
        }
        CalculatorLabel(label = "TIME", fontWeight = FontWeight.Bold, fontSize = 20)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = hours,
                label = "Hours",
                enabled = true,
                onTextChange = { hours = it })
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = minutes,
                label = "Minutes",
                enabled = true,
                onTextChange = { minutes = it })
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = seconds,
                label = "Seconds",
                enabled = true,
                onTextChange = { seconds = it })
        }
        CalculatorLabel(label = "PACE", fontWeight = FontWeight.Bold, fontSize = 20)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = minPace,
                label = "MinPace",
                enabled = true,
                onTextChange = { minPace = it })
            CalculatorTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                text = segPace,
                label = "SecPace",
                enabled = true,
                onTextChange = { segPace = it })
        }
        Spacer(modifier = Modifier.height(50.dp))
        CalculatorButton(
            text = "CALCULAR",
            onClick = {
                Log.d("PACE", "gg+")
            },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "Race Pace Calculator")
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF689F38))
    )
}
