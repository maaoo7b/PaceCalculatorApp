package com.maodev.pacecalculatorapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorLabel(
    modifier: Modifier = Modifier,
    label: String,
    fontWeight: FontWeight,
    fontSize: Int
) {
    Text(
        text = label,
        modifier = Modifier.padding(16.dp),
        fontWeight = fontWeight,
        fontSize = fontSize.sp
    )
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CalculatorTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    enabled: Boolean,
    onTextChange: (String) -> Unit,
    onIMEAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFDCE5D2)),
        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onIMEAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(Color(0xFFDCE5D2))
    ) {
        Text(text = text.uppercase(), color = Color.Black)
    }

}