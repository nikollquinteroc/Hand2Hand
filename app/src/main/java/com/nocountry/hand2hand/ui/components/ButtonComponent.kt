package com.nocountry.hand2hand.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent(
    text: String,
    backgroundColorButton: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick, modifier = modifier
            .width(380.dp)
            .height(52.dp)
            .background(
                color = backgroundColorButton,
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Text(
            text = text,
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    MaterialTheme {
        ButtonComponent(
            text = "Crear una nueva publicación",
            backgroundColorButton = Color(0xFF23675E),
            onClick = {})
    }
}