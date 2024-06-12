package com.nocountry.hand2hand.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.hand2hand.R

@Composable
@Preview
fun TopBarHomePreview(){
    TopBarHome()

}
@Composable
fun TopBarHome(){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF6f50e9),
            ).padding(10.dp)
    ){
       Icon(
           painter = painterResource(R.drawable.ic_hand2),
           contentDescription =  "",
           modifier = Modifier.padding(4.dp),
           tint = Color.White
       )
        Box(
            modifier = Modifier.padding(4.dp).weight(1f)
        ){

            Icon(
                painter = painterResource(R.drawable.ic_logo2_hand2hand),
                contentDescription =  "",
                modifier = Modifier.padding(4.dp),
                tint = Color.White
            )
        }
        Icon(
            painter = painterResource(R.drawable.ic_notification_2),
            contentDescription =  "",
            modifier = Modifier.padding(4.dp),
            tint = Color.White
        )
        Icon(
            painter = painterResource(R.drawable.ic_cart),
            contentDescription =  "",
            modifier = Modifier.padding(4.dp),
            tint = Color.White
        )

    }

}