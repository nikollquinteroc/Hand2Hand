package com.example.saleapp.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigationBar() {

}

@Composable
fun BottomNavigationBarItem(
    route: String,
    icon: ImageVector,
    nameIcon: Int,
    navigateToRoute: (String) -> Unit
) {
    BottomAppBar {
        IconButton(onClick = { navigateToRoute(route) }) {
            Column {
                Icon(
                    imageVector = icon,
                    contentDescription = "Home"
                )
                Text(text = stringResource(id = nameIcon))
            }
        }
    }
}