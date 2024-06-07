package com.nocountry.hand2hand.ui.components

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ImagePicker(multipleImagePickerLauncher: ManagedActivityResultLauncher<PickVisualMediaRequest, List<@JvmSuppressWildcards Uri>>?) {
    Column {
        Card(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(0xFFA58FF7),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(1.dp)
                .width(380.dp)
                .height(112.dp)
                .clickable { launchPicker(multipleImagePickerLauncher) }
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
                .padding(start = 32.dp, top = 24.dp, end = 32.dp, bottom = 24.dp)
        ) {
            TextButton(
                onClick = { launchPicker(multipleImagePickerLauncher) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFFFFF))
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = Color(0xFFA58FF7),
                    modifier = Modifier
                        .padding(1.dp)
                        .width(64.dp)
                        .height(64.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Agregar imagén",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFA58FF7),
                    modifier = Modifier
                        .width(101.dp)
                        .height(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .width(380.dp)
                .height(16.dp)
                .padding(1.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "Podes subir hasta 8 imágenes como máximo.",
                style = MaterialTheme.typography.labelSmall, color = Color(0xFF807E7E),
                modifier = Modifier
                    .width(245.dp)
                    .height(16.dp)
            )
            Text(
                text = "0/8",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF6F50E9),
                modifier = Modifier
                    .padding(start = 85.dp)
                    .width(245.dp)
                    .height(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .width(380.dp)
                .height(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = null,
                tint = Color(0xFF0065FF)
            )
            Text(
                text = "Aprende a tomar las mejores fotos",
                style = MaterialTheme.typography.labelLarge,
                color = Color(0xFF0065FF),
                modifier = Modifier
                    .width(245.dp)
                    .height(16.dp)
            )
        }
    }
}

private fun launchPicker(multipleImagePickerLauncher: ManagedActivityResultLauncher<PickVisualMediaRequest, List<@JvmSuppressWildcards Uri>>?) {
    multipleImagePickerLauncher?.launch(
        PickVisualMediaRequest(
            ActivityResultContracts.PickVisualMedia.ImageOnly
        )
    )
}

@Preview
@Composable
fun ImagePickerPreview() {
    MaterialTheme {
        ImagePicker(multipleImagePickerLauncher = null)
    }
}
