package com.nocountry.hand2hand.view.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R

@Composable
@Preview
fun PerfilScreenPreview(){
    PerfilScreen(onBack = {}, onMicuentaClick = {})

}
@Composable
fun PerfilScreen(
    onBack: () -> Unit,
    onMicuentaClick: () -> Unit

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(1.dp)
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(25.dp), clip = false)
                .background(color = Color.White)

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_back),
                contentDescription ="" ,
                modifier = Modifier.clickable { onBack()  }

                )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = "Perfil",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
            Icon(
                painter = painterResource(R.drawable.ic_notification_2),
                contentDescription = null,
            )

        }
        Divider()
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF9E06B8),
                )

        ) {
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(100.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.img),
                contentDescription = "")

            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                TarjBox(titulo = "Hello")
                Spacer(modifier = Modifier.height(5.dp))
                TarjBox(titulo = "Abdur Rahim")
                Spacer(modifier = Modifier.height(5.dp))
                TarjBox(titulo = "Find your product in cheap price")
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        ItemPerfil("Mi cuenta", R.drawable.ic_chevron_inv2)

        Spacer(modifier = Modifier.height(5.dp))
        ItemPerfil("Favoritos", R.drawable.ic_chevron_inv2)
        Spacer(modifier = Modifier.height(5.dp))
        ItemPerfil("Mis compras", R.drawable.ic_chevron_inv2)
        Spacer(modifier = Modifier.height(5.dp))
        ItemPerfil("Mis ventas ", R.drawable.ic_chevron_inv2)
        Spacer(modifier = Modifier.height(5.dp))
        ItemPerfil("Configuracion", R.drawable.ic_chevron_inv2)
        Spacer(modifier = Modifier.height(5.dp))
        ItemPerfil("Ayuda", R.drawable.ic_chevron_inv2)
        Spacer(modifier = Modifier.height(5.dp))
        ItemPerfil("Cerrar sesion", R.drawable.ic_chevron_inv2)


    }

}
@Composable
fun TarjBox(
    titulo: String
){
    Box(){
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
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(55.dp)
                .background(
                    color = Color.Gray, shape = RoundedCornerShape(50.dp)
                )
        ) {
        }
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
            modifier = Modifier.clickable {  }
        )

    }

    Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp, ))

}