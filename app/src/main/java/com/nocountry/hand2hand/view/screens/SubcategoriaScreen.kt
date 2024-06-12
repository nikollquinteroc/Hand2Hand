package com.nocountry.hand2hand.view.screens

import android.content.res.Resources
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.data.CategoryManager
import com.nocountry.hand2hand.data.SubcategoryManager
import com.nocountry.hand2hand.model.SubCategory
import kotlinx.coroutines.flow.count


@Composable
fun SubcategoriaScreen(
    navigation: NavHostController
){
    var showAddContactDialog by remember { mutableStateOf(false) }
    val realtime by remember { mutableStateOf(SubcategoryManager()) }
    val categoryConnection by remember { mutableStateOf(CategoryManager()) }
    val authManager by remember { mutableStateOf(FirebaseAuth.getInstance()) }
    val contacts by categoryConnection.getContactsFlow().collectAsState(emptyList())
    var currentCategoria by remember{ mutableStateOf("") }
    val subcategories by realtime.getContactsFlow(currentCategoria).collectAsState(emptyList())

    val context = LocalContext.current
    val resources: Resources = context.getResources()

    Column(modifier = Modifier.fillMaxSize()){
        LazyRow(modifier = Modifier.background(color = Color.DarkGray)) {
            if(!contacts.isNullOrEmpty()) {
                for (categoria in contacts) {
                    val resourceId: Int = resources.getIdentifier(
                        categoria.icon, "drawable",
                        context.getPackageName()
                    )
                    item{
                        Image(painter = painterResource(resourceId),
                            contentDescription = categoria.name,
                            modifier = Modifier.clickable { currentCategoria = categoria.key }
                        )
                    }
                }
            }
        }

        if(!subcategories.isNullOrEmpty()) {
            LazyColumn {
                subcategories.forEach { contact ->
                    item {
                        ContactItem(contact = contact, realtime = realtime)
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = painterResource(id = R.drawable.user), contentDescription = null, modifier = Modifier.size(100.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "No se encontraron \nContactos",
                    fontSize = 18.sp, fontWeight = FontWeight.Thin, textAlign = TextAlign.Center)
            }
        }
    }

//    for (categoria in contacts){
//        currentCategoria = categoria.key
//            if(subcategories.count() == 0){
//            val subcategoria1 = SubCategory(name = "1 Sub-${categoria.name}", ctegoryKey = categoria.key)
//            val subcategoria2 = SubCategory(name = "2 Sub-${categoria.name}", ctegoryKey = categoria.key)
//            val subcategoria3 = SubCategory(name = "3 Sub-${categoria.name}", ctegoryKey = categoria.key)
//
//            realtime.addContact(subcategoria1)
//            realtime.addContact(subcategoria2)
//            realtime.addContact(subcategoria3)
//        }
//    }


}

@Composable
fun ContactItem(contact: SubCategory, realtime: SubcategoryManager) {
    var showDeleteContactDialog by remember { mutableStateOf(false) }

    val onDeleteContactConfirmed: () -> Unit = {
        realtime.deleteContact(contact.key ?: "")
    }

    if (showDeleteContactDialog) {
        DeleteContactDialog(
            onConfirmDelete = {
                onDeleteContactConfirmed()
                showDeleteContactDialog = false
            },
            onDismiss = {
                showDeleteContactDialog = false
            }
        )
    }

    Card(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 0.dp)
            .fillMaxWidth())
    {
        Row(
            modifier = Modifier
                .background(color = Color.DarkGray)
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = contact.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                color = Color.LightGray,
                overflow = TextOverflow.Ellipsis)
        }
        Button(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray), onClick = { onDeleteContactConfirmed() }) {
            Text(text = "Eliminar")
        }
    }
}

@Composable
fun AddCategoryDialog(oncategoryAdded: (SubCategory) -> Unit, onDialogDismissed: () -> Unit, authManager: FirebaseAuth) {
    var name by remember { mutableStateOf("") }
    var icon by remember { mutableStateOf("") }
    var uid = authManager.getCurrentUser()?.uid

    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Agregar Categoria") },
        confirmButton = {
            Button(
                onClick = {
//                    val newContact = SubCategory(
//                        name = name
//                    )
//                    oncategoryAdded(newContact)
//                    name = ""
//                    icon = ""
                }
            ) {
                Text(text = "Agregar")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDialogDismissed()
                }
            ) {
                Text(text = "Cancelar")
            }
        },
        text = {
            Column {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text(text = "Nombre") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = icon,
                    onValueChange = { icon = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                    label = { Text(text = "Teléfono") }
                )
            }
        }
    )
}
//@Composable
//fun EditContactDialog(contact: Contact, onContactEdited: (Contact) -> Unit, onDialogDismissed: () -> Unit, authManager: FirebaseAuth) {
//    var name by remember { mutableStateOf(contact.name) }
//    var phoneNumber by remember { mutableStateOf(contact.phoneNumber) }
//    var email by remember { mutableStateOf(contact.email) }
//    var uid = authManager.getCurrentUser()?.uid
//
//    AlertDialog(
//        onDismissRequest = {},
//        title = { Text(text = "Agregar Contacto") },
//        confirmButton = {
//            Button(
//                onClick = {
//                    val newContact = Contact(
//                        name = name,
//                        phoneNumber = phoneNumber,
//                        email = email,
//                        key = contact.key,
//                        uid = uid.toString())
//                    onContactEdited(newContact)
//                    name = ""
//                    phoneNumber = ""
//                    email = ""
//                }
//            ) {
//                Text(text = "Guardar Cambios")
//            }
//        },
//        dismissButton = {
//            Button(
//                onClick = {
//                    onDialogDismissed()
//                }
//            ) {
//                Text(text = "Cancelar")
//            }
//        },
//        text = {
//            Column {
//                TextField(
//                    value = name,
//                    onValueChange = { name = it },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
//                    label = { Text(text = "Nombre") }
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                TextField(
//                    value = phoneNumber,
//                    onValueChange = { phoneNumber = it },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
//                    label = { Text(text = "Teléfono") }
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                TextField(
//                    value = email,
//                    onValueChange = { email = it },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//                    label = { Text(text = "Correo electrónico") }
//                )
//            }
//        }
//    )
//}