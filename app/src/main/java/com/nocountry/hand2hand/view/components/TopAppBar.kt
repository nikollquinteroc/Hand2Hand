package com.nocountry.hand2hand.view.components


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.hand2hand.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    titleScreen: Int,
    onClickBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = titleScreen),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .width(336.dp)
                    .height(28.dp)
                    .padding(start = 10.dp),
                color = Color(0xFFFFFFFF)
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onClickBack,
                modifier = Modifier
                    .height(28.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier.size(60.dp)
                )

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6F50E9)),
    )
}

@Preview
@Composable
fun TopAppBarComponentPreview() {
    MaterialTheme {
        TopAppBarComponent(titleScreen = R.string.new_publication, onClickBack = {})
    }
}