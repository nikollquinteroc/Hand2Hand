package com.nocountry.hand2hand.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.ui.components.ButtonComponent
import com.nocountry.hand2hand.ui.components.SpacerComponent

@Composable
fun ErrorScreen(navigateUp: () -> Unit) {
    Column(
        modifier = Modifier
            .width(420.dp)
            .height(800.dp)
            .background(color = Color(0xFFEDEDED))
            .padding(start = 20.dp, top = 71.dp, end = 20.dp, bottom = 71.17126.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = null, modifier = Modifier
                .padding(0.91651.dp)
                .width(350.dp)
                .height(234.8287.dp),
            contentScale = ContentScale.None
        )
        SpacerComponent(modifier = Modifier.height(70.dp))
        Text(
            text = "Oops!",
            modifier = Modifier
                .width(380.dp)
                .height(68.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 60.sp,
                fontWeight = FontWeight(900)
            ), color = Color(0xFF6F50E9)
        )
        SpacerComponent(modifier = Modifier.height(48.dp))
        Text(text = "Algo salió mal", style = MaterialTheme.typography.bodyLarge)
        Text(
            text = "Por favor, intente más tarde",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight(400))
        )
        SpacerComponent(modifier = Modifier.height(70.dp))
        ButtonComponent(
            text = stringResource(id = R.string.go_back),
            backgroundColorButton = Color(0xFF6F50E9),
            onClick = navigateUp
        )
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    MaterialTheme {
        ErrorScreen(navigateUp = {})
    }
}