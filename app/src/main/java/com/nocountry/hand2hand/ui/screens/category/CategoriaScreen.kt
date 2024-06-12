package com.nocountry.hand2hand.ui.screens.category

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.nocountry.hand2hand.data.model.firebase_realtime.Category
import com.nocountry.hand2hand.ui.prueba.model.Contact


@SuppressLint("SuspiciousIndentation")
@Composable
fun CategoriaScreen(
    navigation: NavHostController
){
    var showAddContactDialog by remember { mutableStateOf(false) }
    val realtime by remember { mutableStateOf(CategoryManager()) }
    val authManager by remember { mutableStateOf(FirebaseAuth.getInstance()) }
    val contacts by realtime.getContactsFlow().collectAsState(emptyList())

//    val component_110 = Category(icon = "component_110" , name = "Cuidados y belleza")
//    realtime.addContact(component_110)
//
//    val component_113 = Category(icon = "component_113", name = "Hogar")
//    realtime.addContact(component_113)
//
//    val component_106 = Category(icon = "component_106" , name = "Moda")
//    realtime.addContact(component_106)
//
//    val component_115 = Category(icon = "component_115", name = "Bebés")
//    realtime.addContact(component_115)
//
//    val component_109 = Category(icon = "component_109", name = "Mascotas")
//    realtime.addContact(component_109)
//
//    val component_107 = Category(icon = "component_107" , name = "Construcción")
//    realtime.addContact(component_107)

//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    showAddContactDialog = true
//                },
//            ) {
//                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Add Contact")
//            }
//
//            if (showAddContactDialog) {
//                AddCategoryDialog(
//                    oncategoryAdded = { contact ->
//                        realtime.addContact(contact)
//                        showAddContactDialog = false
//                    },
//                    onDialogDismissed = { showAddContactDialog = false },
//                    authManager = authManager,
//                )
//            }
//        }
//    ) { _  ->
        if(!contacts.isNullOrEmpty()) {
            LazyColumn {
                contacts.forEach { contact ->
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
//    }
}

@Composable
fun ContactItem(contact: Category, realtime: CategoryManager) {
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
            modifier = Modifier.background(color = Color.DarkGray)
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val resources: Resources = LocalContext.current.getResources()
            val resourceId: Int = resources.getIdentifier(
                contact.icon, "drawable",
                LocalContext.current.getPackageName()
            )
            Image(painter = painterResource(resourceId), contentDescription = contact.name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
            text = contact.name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            maxLines = 1,
            color = Color.LightGray,
            overflow = TextOverflow.Ellipsis)
        }
        Button(modifier = Modifier.fillMaxSize().background(color = Color.DarkGray), onClick = { onDeleteContactConfirmed() }) {
            Text(text = "Eliminar")
        }
    }
}

@Composable
fun AddCategoryDialog(oncategoryAdded: (Category) -> Unit, onDialogDismissed: () -> Unit, authManager: FirebaseAuth) {
    var name by remember { mutableStateOf("") }
    var icon by remember { mutableStateOf("") }
    var uid = authManager.getCurrentUser()?.uid

    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Agregar Categoria") },
        confirmButton = {
            Button(
                onClick = {
                    val newContact = Category(
                        name = name,
                        icon = icon
                    )
                    oncategoryAdded(newContact)
                    name = ""
                    icon = ""
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
@Composable
fun EditContactDialog(contact: Contact, onContactEdited: (Contact) -> Unit, onDialogDismissed: () -> Unit, authManager: FirebaseAuth) {
    var name by remember { mutableStateOf(contact.name) }
    var phoneNumber by remember { mutableStateOf(contact.phoneNumber) }
    var email by remember { mutableStateOf(contact.email) }
    var uid = authManager.getCurrentUser()?.uid

    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Agregar Contacto") },
        confirmButton = {
            Button(
                onClick = {
                    val newContact = Contact(
                        name = name,
                        phoneNumber = phoneNumber,
                        email = email,
                        key = contact.key,
                        uid = uid.toString())
                    onContactEdited(newContact)
                    name = ""
                    phoneNumber = ""
                    email = ""
                }
            ) {
                Text(text = "Guardar Cambios")
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
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                    label = { Text(text = "Teléfono") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    label = { Text(text = "Correo electrónico") }
                )
            }
        }
    )
}

@Composable
fun DeleteContactDialog(onConfirmDelete: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Eliminar contacto") },
        text = { Text("¿Estás seguro que deseas eliminar el contacto?") },
        confirmButton = {
            Button(
                onClick = onConfirmDelete
            ) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancelar")
            }
        }
    )
}