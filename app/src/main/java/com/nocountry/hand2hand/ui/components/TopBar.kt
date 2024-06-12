package com.nocountry.hand2hand.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R


@Composable
@Preview
fun TopBarPreview(){
   // TopBar("Perfil",){}
}

@Composable
fun TopBar(
   // @DrawableRes icon: Int,
    title: String,
    onBack: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(25.dp), clip = false)
            .background(color = Color(0xFF6f50e9), shape = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp))
            .padding(5.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.back),
            contentDescription ="" ,
            modifier = Modifier.clickable { onBack() },
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            color = Color.White,
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Icon(
            painter = painterResource(R.drawable.component_142),
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(15.dp))
        Icon(
            painter = painterResource(R.drawable.component_143),
            contentDescription = null,
            tint = Color.White
        )

    }
}