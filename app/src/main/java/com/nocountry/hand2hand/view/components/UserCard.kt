package com.nocountry.hand2hand.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R

@Composable
@Preview
fun UserCardPreview(){
    UserCard()
}
@Composable
fun UserCard(){

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                )

        ) {
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(100.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.user_pic),
                contentDescription = "")

            Spacer(modifier = Modifier.width(10.dp))
            Column() {

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Nombre y apellido",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "@Juanitostore22",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
            }
        }
}