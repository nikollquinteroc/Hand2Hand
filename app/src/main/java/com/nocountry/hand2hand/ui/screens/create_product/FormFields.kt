package com.nocountry.hand2hand.ui.screens.create_product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.data.model.firebase.Category
import com.nocountry.hand2hand.data.model.firebase.State
import com.nocountry.hand2hand.ui.components.OutlinedTextFieldComponent
import com.nocountry.hand2hand.ui.components.SpacerComponent
import com.nocountry.hand2hand.ui.components.TextButtonComponent
import com.nocountry.hand2hand.ui.components.TitleComponent

@Composable
fun FormFields(categories: List<Category>, states: List<State>) {
    Column(
        modifier = Modifier
            .width(380.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        TitleComponent(
            text = stringResource(id = R.string.category),
            MaterialTheme.typography.bodySmall
        )
        TextButtonComponent(
            textLabel = stringResource(id = R.string.category_label),
            options = categories,
            getDescription = { it.description }
        )
        SpacerComponent()
        TitleComponent(
            text = stringResource(id = R.string.title_product),
            MaterialTheme.typography.bodySmall
        )
        OutlinedTextFieldComponent(
            textLabel = stringResource(id = R.string.title_product_label),
            options = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        SpacerComponent()
        TitleComponent(
            text = stringResource(id = R.string.description_product),
            MaterialTheme.typography.bodySmall
        )
        OutlinedTextFieldComponent(
            textLabel = stringResource(id = R.string.description_product_label),
            options = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        SpacerComponent()
        TitleComponent(
            text = stringResource(id = R.string.real_price_product),
            MaterialTheme.typography.bodySmall
        )
        OutlinedTextFieldComponent(
            textLabel = stringResource(id = R.string.real_price_product_label),
            options = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        SpacerComponent()
        TitleComponent(
            text = stringResource(id = R.string.discount_price_product),
            MaterialTheme.typography.bodySmall
        )
        OutlinedTextFieldComponent(
            textLabel = stringResource(id = R.string.discount_price_product_label),
            options = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        SpacerComponent()
        TitleComponent(
            text = stringResource(id = R.string.state_product),
            MaterialTheme.typography.bodySmall
        )
        TextButtonComponent(
            textLabel = stringResource(id = R.string.state_product_label),
            options = states,
            getDescription = { it.description }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionsEditPreview() {
    MaterialTheme {
        FormFields(emptyList(), emptyList())
    }
}