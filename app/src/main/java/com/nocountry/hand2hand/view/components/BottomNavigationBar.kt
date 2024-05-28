package com.nocountry.hand2hand.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.view.navigation.MainDestinations

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navigateToRoute: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        BottomAppBar {
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.HOME_ROUTE) },
                icon = Icons.Default.Home,
                nameIcon = R.string.home_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.SEARCH_ROUTE) },
                icon = Icons.Default.Search,
                nameIcon = R.string.search_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.BUYING_ROUTE) },
                icon = Icons.Default.ShoppingBag,
                nameIcon = R.string.buying_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.SELLING_ROUTE) },
                icon = Icons.Default.Sell,
                nameIcon = R.string.selling_bar
            )
            BottomNavigationBarItem(
                onClick = { navigateToRoute(MainDestinations.ACCOUNT_ROUTE) },
                icon = Icons.Default.AccountCircle,
                nameIcon = R.string.account_bar
            )
        }
    }
}

@Composable
fun BottomNavigationBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    nameIcon: Int
) {
    IconButton(onClick = onClick, modifier = modifier
        .padding(5.dp)
        .size(70.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
            Text(
                text = stringResource(id = nameIcon),
                fontSize = 12.sp,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    MaterialTheme {
        BottomNavigationBar(navigateToRoute = { MainDestinations.HOME_ROUTE })
    }
}