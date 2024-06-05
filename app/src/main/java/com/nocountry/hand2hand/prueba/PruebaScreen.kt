package com.nocountry.hand2hand.prueba

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.nocountry.hand2hand.data.UserManager
import com.nocountry.hand2hand.model.User
import java.util.Date


@Composable
@Preview
fun PruebaScreenPreview(){
    PruebaScreen(onGuardar = {})

}
@Composable
fun PruebaScreen(
    onGuardar: () -> Unit
    ){
    var name by remember { mutableStateOf("yonissa") }
    var lastname by remember { mutableStateOf("jaquez") }
    var birthdate by remember { mutableStateOf("17-11-1995") }
    var phone by remember { mutableStateOf("8098786265") }
    var e_mail by remember { mutableStateOf("yoniJ@mail.com") }
    var address by remember { mutableStateOf("c la pradera #51") }
    var uri by remember { mutableStateOf(" ") }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(

        ) {
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
            TextField(value = uri, onValueChange ={uri = it  },
                label  = { Text(text = "uid") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(onClick = {
                //onGuardar()

                FirebaseAuth.getInstance().signInWithEmailAndPassword("yoni@mail.com", "123456")
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
             },

            ) {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = "Guardar",
                    textAlign = TextAlign.Center
                )

            }

        }


    }


}