package com.nocountry.hand2hand.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
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
import com.nocountry.hand2hand.data.UserManager
import com.nocountry.hand2hand.model.User
import com.nocountry.hand2hand.view.navigation.MainDestinations

@Composable
@Preview
fun RegistroScreenPreview() {
//    RegistroScreen(onRigister = {})
}

@Composable
fun RegisterScreen(
    navigation: NavHostController
){
    //campos usuario y validar contraseña
    var username by remember { mutableStateOf("saraza@mail.com") }
    var password by remember { mutableStateOf("123456") }
    var passwordRepeat by remember { mutableStateOf("123456") }

    //datos usuario
    var name by remember { mutableStateOf("saraza") }
    var lastname by remember { mutableStateOf("apellido") }
    var birthdate by remember { mutableStateOf("17-11-1998") }
    var phone by remember { mutableStateOf("8098786275") }
    var e_mail by remember { mutableStateOf("saraza@mail.com") }
    var address by remember { mutableStateOf("casa de al lado") }

    var displayAlert by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item{
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

                TextField(value = passwordRepeat, onValueChange ={ passwordRepeat = it },
                    label  = { Text(text = "Repeat Password") },
                    maxLines = 1,
                    singleLine = true

                )
                Spacer(modifier = Modifier.height(25.dp))

                TextField(value = name, onValueChange ={ name = it },
                    label  = { Text(text = "name") },
                    maxLines = 1,
                    singleLine = true

                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(value = lastname, onValueChange ={lastname = it  },
                    label  = { Text(text = "last name") },
                    maxLines = 1,
                    singleLine = true

                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(value =birthdate, onValueChange ={lastname = it  },
                    label  = { Text(text = "birthdate") },
                    maxLines = 1,
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(value = phone, onValueChange ={ phone = it },
                    label  = { Text(text = "phone") },
                    maxLines = 1,
                    singleLine = true

                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(value = e_mail, onValueChange ={ e_mail = it },
                    label  = { Text(text = "e_mail") },
                    maxLines = 1,
                    singleLine = true

                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(value = address, onValueChange ={ address = it },
                    label  = { Text(text = "address") },
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
                        if(username.isNotBlank()
                            && password.isNotBlank()
                            && passwordRepeat.isNotBlank()
                            && password == passwordRepeat
                        ){
                            FirebaseAuth.getInstance()
                                .createUserWithEmailAndPassword(username , password)
                                .addOnCompleteListener{
                                    if(it.isSuccessful){
                                        FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                                        val user = User(
                                            name = name,
                                            lastName = lastname,
                                            birthDate = birthdate,
                                            phone = phone,
                                            e_mail = e_mail,
                                            address = address,
                                            uid = FirebaseAuth.getInstance().currentUser?.uid?:""
                                        )

                                        UserManager().addUser(user)

                                        navigation.navigate(MainDestinations.HOME_ROUTE)
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