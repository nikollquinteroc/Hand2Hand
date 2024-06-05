package com.nocountry.hand2hand.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun InformacionPersonalScreenPreview(){
    InformacionPersonalScreen()

}
@Composable
fun InformacionPersonalScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(

        ) {
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "name") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "last name") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "birthdate") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "phone") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "e_mail") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "address") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(value = "", onValueChange ={  },
                label  = { Text(text = "uid") },
                maxLines = 1,
                singleLine = true

            )
            Spacer(modifier = Modifier.height(25.dp))

        }


    }


}