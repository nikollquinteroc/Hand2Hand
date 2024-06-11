package com.nocountry.hand2hand.ui.screens.product_created

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.ui.components.ButtonComponent
import com.nocountry.hand2hand.ui.components.SpacerComponent

@Composable
fun ProductCreatedScreen(navigateToHome: () -> Unit, message: String) {

    Column(
        modifier = Modifier.padding(start = 32.dp, top = 32.dp, end = 32.dp, bottom = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.product_created),
            contentDescription = null,
            modifier = Modifier
                .width(236.dp)
                .height(236.dp)
        )
        SpacerComponent()
        Text(
            text = stringResource(id = R.string.title_product_created),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        SpacerComponent()
        Text(
            text = message,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight(400)),
            textAlign = TextAlign.Center
        )
        SpacerComponent(modifier = Modifier.height(30.dp))
        ButtonComponent(
            text = stringResource(id = R.string.go_back),
            backgroundColorButton = Color(0xFF6F50E9),
            onClick = navigateToHome
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCreatedScreenPreview() {
    MaterialTheme {
        ProductCreatedScreen(navigateToHome = {}, message = "Test")
    }
}