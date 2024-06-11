package com.nocountry.hand2hand.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TitleComponent(text:String, style: TextStyle) {
    Text(
        text = text,
        style = style,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun TitleComponentPreview() {
    MaterialTheme {
        TitleComponent(text = "Test", MaterialTheme.typography.bodySmall)
    }
}