package com.nocountry.hand2hand.view.screens.new_publication


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.view.components.TopAppBarComponent

@Composable
fun NewPublicationScreen(
    navigateUp: () -> Unit,
    onClickNewPublication: () -> Unit
) {
    val state = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBarComponent(
                titleScreen = R.string.new_publication,
                onClickBack = navigateUp
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state)
                .padding(it)
                .background(Color(0xFFEDEDED))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Retoma la publicación",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                ResumePublication()
                Spacer(modifier = Modifier.height(80.dp))
                TextButton(
                    onClick = onClickNewPublication, modifier = Modifier
                        .width(380.dp)
                        .height(52.dp)
                        .background(
                            color = Color(0xFF23675E),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        //.padding(start = 24.dp, top = 12.dp, end = 24.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = "Crear una nueva publicación",
                        color = Color(0xFFFFFFFF),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .width(228.dp)
                            .height(28.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ResumePublication() {
    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start, modifier = Modifier
                .shadow(
                    elevation = 6.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .width(380.dp)
                .height(258.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card_new_publication),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFFFFF))
                    .weight(1f)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Bicicleta vintage",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = "Seminuevo", style = MaterialTheme.typography.bodyLarge)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = "$70.000", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "$95.000",
                        color = Color(0xFF6F50E9),
                        textDecoration = TextDecoration.LineThrough
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .weight(2f)
                            .height(32.dp)
                            .background(
                                color = Color(0xFF6F50E9),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                        .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Continuar editando",
                            color = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .height(15.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFF6F50E9),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                            .weight(1f)
                            .height(32.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 6.dp)
                            )
                        //.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.delete),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Eliminar",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF43308C),
                            /*modifier = Modifier
                                .width(44.dp)
                                .height(15.dp)*/
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun NewPublicationScreenPreview() {
    MaterialTheme {
        NewPublicationScreen({}, {})
        //ResumePublication()
    }
}