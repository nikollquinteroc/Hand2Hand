package com.nocountry.hand2hand.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldComponent(textLabel: String, options: KeyboardOptions) {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        keyboardOptions = options,
        onValueChange = { text = it },
        label = {
            Text(
                text = textLabel,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF7C7986),
                modifier = Modifier
                    .width(348.dp)
                    .height(24.dp)
            )
        },
        textStyle = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Normal),
        modifier = Modifier
            .width(380.dp)
            .height(60.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
            /*.border(
                width = 1.dp,
                color = Color(0xFF6F50E9),
                shape = RoundedCornerShape(size = 8.dp)
            )*/



    )
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextFieldComponentPreview() {
    MaterialTheme {
        OutlinedTextFieldComponent(
            "Test",
            options = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
    }
}