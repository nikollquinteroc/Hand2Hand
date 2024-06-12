package com.nocountry.hand2hand.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R

@Composable
fun PerfilButton(
    titulo: String,
    @DrawableRes icon: Int,
    onItemClick: () -> Unit
) {
    Column(modifier = Modifier.clickable { onItemClick() }){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
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
                painter = painterResource(R.drawable.user),
                contentDescription = "",
                modifier = Modifier.clickable { }
            )
            /*Icon(
                painter = painterResource(R.drawable.ic_chevron_inv2),
                contentDescription = "",
                modifier = Modifier.clickable { }
            )*/
        }

        Divider(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp,))
    }
}