package com.nocountry.hand2hand.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.view.components.BottomNavigationBar
import com.nocountry.hand2hand.view.components.PerfilButton
import com.nocountry.hand2hand.view.components.TopBar
import com.nocountry.hand2hand.view.components.UserCard

@Composable
@Preview
fun MiCuentaScreenPreview(){
    MiCuentaScreen(  navigation = rememberNavController())

}
@Composable
fun MiCuentaScreen(
    navigation: NavHostController,

){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        TopBar("Mi Cuenta"){navigation.popBackStack()}
        Divider()
        Spacer(modifier = Modifier.height(15.dp))
        Box(modifier = Modifier
            .padding(15.dp)
            .border(
                width = 0.dp,
                color = Color(0xFF31628d)
            )
        ){
            UserCard()
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(modifier = Modifier
            .weight(1f)
            .padding(10.dp)
        ) {
            item {

                Column (modifier = Modifier
                ){
                    PerfilButton(titulo = "Información Personal", icon = R.drawable.ic_user){navigation.navigate("InformacionPersonal")}
                    PerfilButton(titulo = "Dato de la cuenta", icon = R.drawable.ic_datocuenta){}
                    PerfilButton(titulo = "Seguridad", icon = R.drawable.ic_seguridad){}
                    PerfilButton(titulo = "Tarjeta", icon = R.drawable.ic_tarjeta){}
                    PerfilButton(titulo = "Domicilio", icon = R.drawable.ic_domicilio){}
                }
            }


        }
        BottomNavigationBar {
        }
    }

}