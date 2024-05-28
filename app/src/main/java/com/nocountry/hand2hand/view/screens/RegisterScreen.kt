package com.nocountry.hand2hand.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.nocountry.hand2hand.view.navigation.MainDestinations

@Composable
@Preview
fun RegistroScreenPreview() {
//    RegistroScreen(onRigister = {})
}

@Composable
fun RegistroScreen(
    navigation: NavHostController
){
    var username by remember { mutableStateOf("yoni@mail.com") }
    var password by remember { mutableStateOf("123456") }
    var displayAlert by remember { mutableStateOf(false) }
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

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = username, onValueChange ={ username = it },
                label  = { Text(text = "E-mail") }

            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = password, onValueChange ={ password = it },
                label  = { Text(text = "Password") },
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
                onClick = {
                    if(username.isNotBlank() && password.isNotBlank()){
                        FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(username , password)
                            .addOnCompleteListener{
                                if(it.isSuccessful){
                                    navigation.navigate(MainDestinations.LOGIN_ROUTE)
                                }
                                else{
                                    displayAlert = true
                                }
                            }
                    }
                }
            ) {
                Text(text = "Registrar" )
            }
        }



    }

    if (displayAlert){
        AlertDialog(
            title = {
                Text(text = "No se pudo registrar")
            },
            text = {
                Text(text = "No se pudo registrar el usuario. Intente en unos minutos.")
            },
            onDismissRequest = {
            },
            confirmButton = {
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        displayAlert = false
                    }
                ) {
                    Text("Entendido")
                }
            }
        )
    }

}