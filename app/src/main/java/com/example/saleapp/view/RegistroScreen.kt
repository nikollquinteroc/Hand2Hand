package com.example.saleapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun RegistroScreenPreview() {
    RegistroScreen(onRigister = {})
}

@Composable
fun RegistroScreen(
    onRigister: ()-> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(text = "Sign up",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = "", onValueChange ={},
                label  = { Text(text = "Name") }

            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = "", onValueChange ={},
                label  = { Text(text = "E-mail") }

            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = "", onValueChange ={},
                label  = { Text(text = "PassWord") },
//                trailingIcon = {
//                    Icon(painter = painterResource(R.drawable.ic_log_trail), contentDescription = "")
//                },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))

            Button(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth(.7f),
                colors = ButtonDefaults.buttonColors()
                ,
                onClick = {onRigister () }) {
                Text(text = "Registrar" )
            }
        }



    }

}