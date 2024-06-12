package com.nocountry.hand2hand.ui.prueba

import android.annotation.SuppressLint
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.data.ContactManager
import com.nocountry.hand2hand.ui.prueba.model.Contact


@Composable
@Preview
fun PruebaScreenPreview(){
    PruebaScreen()

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PruebaScreen() {
    var showAddContactDialog by remember { mutableStateOf(false) }
    val realtime by remember { mutableStateOf(ContactManager()) }
    val authManager by remember { mutableStateOf(FirebaseAuth.getInstance()) }
    val contacts by realtime.getContactsFlow().collectAsState(emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showAddContactDialog = true
                },
            ) {
                Icon(painter = painterResource(id = R.drawable.back), contentDescription = "Add Contact")
            }

            if (showAddContactDialog) {
                AddContactDialog(
                    onContactAdded = { contact ->
                        realtime.addContact(contact)
                        showAddContactDialog = false
                    },
                    onDialogDismissed = { showAddContactDialog = false },
                    authManager = authManager,
                )
            }
        }
    ) { _  ->
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
    }
}

@Composable
fun ContactItem(contact: Contact, realtime: ContactManager) {
    var showDeleteContactDialog by remember { mutableStateOf(false) }
    var showEditContactDialog by remember { mutableStateOf(false) }

    val onDeleteContactConfirmed: () -> Unit = {
        realtime.deleteContact(contact.key ?: "")
    }
    val onEditConfirmed: (Contact) -> Unit = {
        realtime.updateContact(contact.key ?: "", it)
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
    if (showEditContactDialog) {
        EditContactDialog(
            contact = contact,
            onContactEdited = {
                onEditConfirmed(it)
                showEditContactDialog = false
            },
            onDialogDismissed = {
                showEditContactDialog = false
            },
            authManager = FirebaseAuth.getInstance()
        )
    }

    Card(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 0.dp)
            .fillMaxWidth())
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = contact.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = contact.phoneNumber,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = contact.uid,
                    fontWeight = FontWeight.Thin,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
            ) {
                IconButton(
                    onClick = {
                        showEditContactDialog = true
                    },
                ) {
                    Icon(painter = painterResource(id = R.drawable.component_107), contentDescription = "Delete Icon")
                }
                IconButton(
                    onClick = {
                        showDeleteContactDialog = true
                    },
                ) {
                    Icon(painter = painterResource(id = R.drawable.delete), contentDescription = "Delete Icon")
                }
            }
        }
    }
}

@Composable
fun AddContactDialog(onContactAdded: (Contact) -> Unit, onDialogDismissed: () -> Unit, authManager: FirebaseAuth) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
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
                        uid = uid.toString())
                    onContactAdded(newContact)
                    name = ""
                    phoneNumber = ""
                    email = ""
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