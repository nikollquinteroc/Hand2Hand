package com.nocountry.hand2hand.view.screens.new_publication

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.model.CategoryNewPublication
import com.nocountry.hand2hand.view.components.TopAppBarComponent

@Composable
fun NewProduct(
    navigateUp: () -> Unit
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
                .padding(it)
                .fillMaxSize()
                .verticalScroll(state)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Completa todos los campos",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Añadir las fotos",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                AddImage()
            }
        }
    }
}

@Composable
fun AddImage() {
    Column {
        Card(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(0xFFA58FF7),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(1.dp)
                .width(380.dp)
                .height(112.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
                .padding(start = 32.dp, top = 24.dp, end = 32.dp, bottom = 24.dp)
        ) {
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFFFFF))
            ) {
                /*Image(
                    painter = painterResource(id = R.drawable.anadir_fotos),
                    contentDescription = null
                )*/
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = Color(0xFFA58FF7),
                    modifier = Modifier
                        .padding(1.dp)
                        .width(64.dp)
                        .height(64.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Agregar imagén",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFA58FF7),
                    modifier = Modifier
                        .width(101.dp)
                        .height(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .width(380.dp)
                .height(16.dp)
                .padding(1.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "Podes subir hasta 8 imágenes como máximo.",
                style = MaterialTheme.typography.labelSmall, color = Color(0xFF807E7E),
                modifier = Modifier
                    .width(245.dp)
                    .height(16.dp)
            )
            Text(
                text = "0/8",
                style = MaterialTheme.typography.labelSmall, fontSize = 12.sp,
                color = Color(0xFF6F50E9),
                modifier = Modifier
                    .padding(start = 85.dp)
                    .width(245.dp)
                    .height(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .width(380.dp)
                .height(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = null,
                tint = Color(0xFF0065FF)
            )
            //Image(painter = painterResource(id = R.drawable.lightbulb), contentDescription = null)
            Text(
                text = "Aprende a tomar las mejores fotos",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF0065FF),
                modifier = Modifier
                    .width(245.dp)
                    .height(16.dp)
            )
        }
    }
}

@Composable
fun CategoriesEdit() {
    Column(
        modifier = Modifier
            .width(380.dp)
            .height(816.dp)
            .padding(1.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {


    }
}

@Composable
fun CategoryEditItem(
    category: CategoryNewPublication
) {

}

@Preview(showBackground = true)
@Composable
fun NewProductPreview() {
    MaterialTheme {
        //NewProduct({})
        //AddImage()
        CategoriesEdit()
    }
}