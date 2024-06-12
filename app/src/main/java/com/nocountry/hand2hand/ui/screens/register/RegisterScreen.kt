package com.nocountry.hand2hand.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.data.UserManager
import com.nocountry.hand2hand.data.model.firebase_realtime.User
import com.nocountry.hand2hand.ui.components.ButtonComponent
import com.nocountry.hand2hand.ui.navigation.MainDestinations
import com.nocountry.hand2hand.ui.screens.account.TextItem

@Composable
@Preview
fun RegistroScreenPreview() {
    RegisterScreen(navigation = rememberNavController())
}

@Composable
fun RegisterScreen(
    navigation: NavHostController
) {
    //campos usuario y validar contraseña
    var username by remember { mutableStateOf("nombre@mail.com") }
    var password by remember { mutableStateOf("123456") }
    var passwordRepeat by remember { mutableStateOf("123456") }

    //datos usuario
    var name by remember { mutableStateOf("nombre") }
    var lastname by remember { mutableStateOf("apellido") }
    var birthdate by remember { mutableStateOf("17-11-1998") }
    var phone by remember { mutableStateOf("8098786275") }
    var e_mail by remember { mutableStateOf("saraza@mail.com") }
    var address by remember { mutableStateOf("casa de al lado") }

    var displayAlert by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(0.dp, 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.width(50.dp)
                        .height(100.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    tint = Color(0xFF6F50E9),
                )
                Spacer(modifier = Modifier.height(5.dp))
                Icon(
                    modifier = Modifier.width(185.dp)
                        .height(44.dp),
                    painter = painterResource(R.drawable.hand2hand),
                    contentDescription = null,
                    tint = Color(0xFF6F50E9)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            Column {

                Text(
                    text = "Crear cuenta",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                )



                Spacer(modifier = Modifier.height(5.dp))

                TextItem(titulo = "Mail", text = username, cambioValor = { username = it })
                TextItem(titulo = "Contraseña", text = password, cambioValor = { password = it })
                TextItem(
                    titulo = "Repite la contraseña",
                    text = passwordRepeat,
                    cambioValor = { passwordRepeat = it })
                TextItem(titulo = "Nombre", text = name, cambioValor = { name = it })
                TextItem(titulo = "Apellido", text = lastname, cambioValor = { lastname = it })
                TextItem(titulo = "Telefono", text = phone, cambioValor = { phone = it })

                Spacer(modifier = Modifier.height(25.dp))

                ButtonComponent(
                    text = "Crear cuenta",
                    backgroundColorButton = Color(0xFF6F50E9),
                    onClick = {
                        if (username.isNotBlank()
                            && password.isNotBlank()
                            && passwordRepeat.isNotBlank()
                            && password == passwordRepeat
                        ) {
                            FirebaseAuth.getInstance()
                                .createUserWithEmailAndPassword(username, password)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        FirebaseAuth.getInstance()
                                            .signInWithEmailAndPassword(username, password)
                                        val user = User(
                                            name = name,
                                            lastName = lastname,
                                            birthDate = birthdate,
                                            phone = phone,
                                            e_mail = e_mail,
                                            address = address,
                                            uid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
                                        )

                                        UserManager().addUser(user)

                                        navigation.navigate(MainDestinations.HOME_ROUTE)
                                    } else {
                                        displayAlert = true
                                    }
                                }
                        }
                    },
                    modifier =  Modifier.padding(15.dp)
                )
                /*Button(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth(.7f),
                    colors = ButtonDefaults.buttonColors(),
                    onClick = {
                        if (username.isNotBlank()
                            && password.isNotBlank()
                            && passwordRepeat.isNotBlank()
                            && password == passwordRepeat
                        ) {
                            FirebaseAuth.getInstance()
                                .createUserWithEmailAndPassword(username, password)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        FirebaseAuth.getInstance()
                                            .signInWithEmailAndPassword(username, password)
                                        val user = User(
                                            name = name,
                                            lastName = lastname,
                                            birthDate = birthdate,
                                            phone = phone,
                                            e_mail = e_mail,
                                            address = address,
                                            uid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
                                        )

                                        UserManager().addUser(user)

                                        navigation.navigate(MainDestinations.HOME_ROUTE)
                                    } else {
                                        displayAlert = true
                                    }
                                }
                        }
                    }
                ) {
                    Text(text = "Registrar")
                }*/
            }
        }


    }

    if (displayAlert) {
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