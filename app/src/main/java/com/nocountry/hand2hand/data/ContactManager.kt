package com.nocountry.hand2hand.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.nocountry.hand2hand.ui.prueba.model.Contact
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ContactManager {

    fun addContact(user: Contact){
        val key = FirebaseConnection.contactDB.push().key
        if (key != null){
            FirebaseConnection.contactDB.child(key).setValue(user)
        }
    }
    fun deleteContact(contactId: String) {
        FirebaseConnection.contactDB.child(contactId).removeValue()
    }

    fun updateContact(contactId: String, updatedContact: Contact) {
        FirebaseConnection.contactDB.child(contactId).setValue(updatedContact)
    }

    fun getContactsFlow(): Flow<List<Contact>> {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword("yoni@mail.com" , "123456")


        val flow = callbackFlow {
            val listener = FirebaseConnection.contactDB.addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val contacts = snapshot.children.mapNotNull {  snapshot ->
                        val contact = snapshot.getValue(Contact::class.java)
                        snapshot.key?.let { contact?.copy(key = it) }
                    }

                    val idFilter = FirebaseAuth.getInstance().currentUser?.uid?:""
                    trySend(contacts.filter { it.uid == idFilter }).isSuccess
                }
                override fun onCancelled(error: DatabaseError) {
                    close(error.toException())
                }
            })
            awaitClose { FirebaseConnection.contactDB.removeEventListener(listener) }
        }
        return flow
    }
}