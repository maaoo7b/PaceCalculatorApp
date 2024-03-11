package com.maodev.pacecalculatorapp.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maodev.pacecalculatorapp.components.CalculatorButton
import com.maodev.pacecalculatorapp.components.CalculatorLabel
import com.maodev.pacecalculatorapp.components.CalculatorTextField


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            MyTopAppBar()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0XFFF8FBF8)),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            CardFields()
        }
    }

}

@Composable
fun CardFields() {
    var distance by remember {
        mutableStateOf("")
    }
    var time by remember {
        mutableStateOf("")
    }
    var pace by remember {
        mutableStateOf("")
    }
    CalculatorLabel(label = "DISTANCE", fontWeight = FontWeight.Bold, fontSize = 20)
    CalculatorTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        text = distance,
        label = "Distance",
        onTextChange = { distance = it })
    CalculatorLabel(label = "TIME", fontWeight = FontWeight.Bold, fontSize = 20)
    CalculatorTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        text = time,
        label = "Time",
        onTextChange = { time = it })
    CalculatorLabel(label = "PACE", fontWeight = FontWeight.Bold, fontSize = 20)
    CalculatorTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        text = pace,
        label = "Pace",
        onTextChange = { pace = it })
    Spacer(modifier = Modifier.height(50.dp))
    CalculatorButton(text = "CALCULAR", onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp).height(50.dp))
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
