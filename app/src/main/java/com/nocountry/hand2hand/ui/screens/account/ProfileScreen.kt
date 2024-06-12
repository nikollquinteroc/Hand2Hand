package com.nocountry.hand2hand.ui.screens.account

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.ui.components.BottomNavigationBar
import com.nocountry.hand2hand.ui.components.PerfilButton
import com.nocountry.hand2hand.ui.components.TopBar
import com.nocountry.hand2hand.ui.components.UserCard
import com.nocountry.hand2hand.ui.navigation.MainDestinations


@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen(navigation = rememberNavController())
}

@Composable
fun ProfileScreen(
    navigation: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        TopBar("Perfil") { navigation.popBackStack("Home", false) }
        HorizontalDivider()
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .padding(15.dp)
                .border(
                    width = 0.dp,
                    color = Color(0xFF31628d)
                )
        ) {
            UserCard()
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            item {

                Column(
                    modifier = Modifier
                ) {
                    PerfilButton(
                        "Mi cuenta",
                        R.drawable.ic_user
                    ) { navigation.navigate("MiCuenta") }
                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilButton(titulo = "Favoritos", icon = R.drawable.ic_fav) {}
                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilButton("Mis compras", R.drawable.ic_carrito) {}
                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilButton("Mis ventas ", R.drawable.ic_venta) {}
                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilButton("Configuracion", R.drawable.ic_conf) {}
                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilButton("Centro de ayuda", R.drawable.ic_help) {}
                    Spacer(modifier = Modifier.height(5.dp))
                    PerfilButton(
                        "Cerrar sesion",
                        R.drawable.ic_cerrar_sesion
                    ) { navigation.navigate(MainDestinations.LOGIN_ROUTE) }
                }
            }
        }
        BottomNavigationBar {
            navigation.navigate(it)
        }
    }
}

@Composable
fun TarjBox(
    titulo: String
) {
    Box {
        Text(
            text = titulo,
            color = Color.White,
            style = TextStyle(
                fontSize = 15.sp
            )
        )

    }

}

@Composable
fun ItemPerfil(
    titulo: String,
    @DrawableRes icon: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(icon),
            contentDescription = "",
            //tint = Color.Blue
        )
        Spacer(modifier = Modifier.width(15.dp))

        Text(
            modifier = Modifier.weight(1f),
            text = titulo,
            style = TextStyle(
                fontSize = 20.sp
            )
        )

        Icon(
            painter = painterResource(icon),
            contentDescription = "",
            modifier = Modifier.clickable { }
        )

    }

    HorizontalDivider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))

}