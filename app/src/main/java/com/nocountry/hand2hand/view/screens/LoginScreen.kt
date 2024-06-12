package com.nocountry.hand2hand.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.view.navigation.MainDestinations

@Composable
fun LoginScreen(navigation: NavHostController) {
    var email by remember { mutableStateOf("yoni@mail.com") }
    var password by remember { mutableStateOf("123456") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var displayAlert by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_default),
                    contentDescription = "Login logo",
                    contentScale = ContentScale.Crop
                )
                Text(text = stringResource(id = R.string.login))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.welcome_back_login))
                //LoginUserInputs()
                //region LoginUserInputs()
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = stringResource(id = R.string.email_label)) }
                    )
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = stringResource(id = R.string.password_label)) },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation =
                        if (passwordVisible)
                            VisualTransformation.None
                        else PasswordVisualTransformation(),
                        trailingIcon = {
                            if (password.isNotBlank()) {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        if (passwordVisible) {
                            Icon(
                                imageVector = Icons.Default.VisibilityOff,
                                contentDescription = "Password icon off"
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Visibility,
                                contentDescription = "Password icon on"
                            )
                        }
                                }
                            }
                        }
                    )
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )
                }
                //endregion LoginUserInputs()


                Text(text = stringResource(id = R.string.forgot_password_login))
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if(email.isNotBlank() && password.isNotBlank()){
                            FirebaseAuth.getInstance()
                                .signInWithEmailAndPassword(email , password)
                                .addOnCompleteListener{
                                    if(it.isSuccessful){
                                        navigation.navigate(MainDestinations.HOME_ROUTE)
                                    }
                                    else{
                                        displayAlert = true
                                    }
                                }
                        }
                    },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }
                Text(text = stringResource(id = R.string.without_account),
                    modifier = Modifier.clickable { navigation.navigate(MainDestinations.REGISTER_ROUTE) })
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


@Composable
fun LoginUserInputs(modifier: Modifier = Modifier) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = stringResource(id = R.string.email_label)) }
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.password_label)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation =
            if (passwordVisible)
                VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                if (password.isNotBlank()) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                        if (passwordVisible) {
//                            Icon(
//                                imageVector = Icons.Default.VisibilityOff,
//                                contentDescription = "Password icon off"
//                            )
//                        } else {
//                            Icon(
//                                imageVector = Icons.Default.Visibility,
//                                contentDescription = "Password icon on"
//                            )
//                        }
                    }
                }
            }
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        //LoginScreen()
    }
}