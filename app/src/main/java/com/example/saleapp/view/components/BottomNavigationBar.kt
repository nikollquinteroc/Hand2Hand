package com.example.saleapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saleapp.R
import com.example.saleapp.view.navigation.MainDestinations

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navigateToRoute: (String) -> Unit
) {
    BottomAppBar {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(75.dp)
        ) {
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.HOME_ROUTE) },
                icon = R.drawable.home,
                nameIcon = R.string.home_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.SEARCH_ROUTE) },
                icon = R.drawable.auction,
                nameIcon = R.string.auction_bar
            )
            BottomSellNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.BUYING_ROUTE) },
                icon = R.drawable.sell_icon,
                nameIcon = R.string.selling_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.SELLING_ROUTE) },
                icon = R.drawable.chat,
                nameIcon = R.string.messages_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.ACCOUNT_ROUTE) },
                icon = R.drawable.user,
                nameIcon = R.string.account_bar
            )
        }
    }
}

@Composable
fun BottomNavigationBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: Int,
    nameIcon: Int
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
            .width(70.dp)
            .height(75.dp)
    ) {
        IconButton(
            onClick = onClick, modifier = Modifier
                .width(70.dp)
                .height(75.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp),
                    contentScale = ContentScale.None
                )
                Text(
                    text = stringResource(id = nameIcon),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .height(12.dp)
                )
            }
        }
    }
}

@Composable
fun BottomSellNavigationBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: Int,
    nameIcon: Int
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
            .width(70.dp)
            .height(75.dp)
    ) {
        IconButton(
            onClick = onClick, modifier = Modifier
                .width(70.dp)
                .height(75.dp).align(Alignment.CenterHorizontally)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(420.dp)
                    .height(75.dp)
            ) {
                Box(
                    Modifier
                        //.offset(x = 182.dp, y = 10.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color(0x66453C61),
                            ambientColor = Color(0x66453C61)
                        )
                        .width(55.dp)
                        .height(55.dp)
                        .background(
                            color = Color(0xFF23675E),
                            shape = RoundedCornerShape(size = 50.dp)
                        )
                        .padding(start = 16.dp, top = 16.dp, end = 15.dp, bottom = 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(24.dp)
                            .height(24.dp),
                        contentScale = ContentScale.None
                    )
                }
                Text(
                    text = stringResource(id = nameIcon),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        //.offset(x = 191.dp, y = 47.dp)
                        .width(39.dp)
                        .height(14.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    MaterialTheme {
        BottomNavigationBar(navigateToRoute = { MainDestinations.HOME_ROUTE })
    }
}