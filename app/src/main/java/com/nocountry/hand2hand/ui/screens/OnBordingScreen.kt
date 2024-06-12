package com.nocountry.hand2hand.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun OnBoardingScreen(navigateToLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .width(420.dp)
            .height(800.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .padding(
                start = 20.dp,
                top = 1.dp,
                end = 20.dp,
                bottom = 12.9326171875.dp
            ),
        verticalArrangement = Arrangement.spacedBy(
            12.93.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_icon),
            contentDescription = null,
            modifier = Modifier
                .width(380.dp)
                .height(92.dp)
        )
        SpacerComponent(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = null, modifier = Modifier
                .padding(0.91651.dp)
                .width(350.dp)
                .height(234.8287.dp),
            contentScale = ContentScale.None
        )
        SpacerComponent(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.welcome_onboarding),
            modifier = Modifier
                .width(380.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 30.sp,
                fontWeight = FontWeight(900)
            ), color = Color(0xFF131221)
        )
        SpacerComponent(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.description_onboarding),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight(400)),
            textAlign = TextAlign.Center,
            //modifier = Modifier.padding(start = 30.dp, end = 30.dp)
        )
        SpacerComponent(modifier = Modifier.height(30.dp))
        ButtonComponent(
            text = stringResource(id = R.string.star_onboarding),
            backgroundColorButton = Color(0xFF6F50E9),
            onClick = navigateToLogin
        )
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    MaterialTheme {
        OnBoardingScreen(navigateToLogin = {})
    }
}