package com.nocountry.hand2hand.prueba.utils

import android.content.Context
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.nocountry.hand2hand.prueba.model.Contact
import kotlinx.coroutines.flow.Flow

class RealTimeManayer( context: Context) {
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("contacts")
    fun addContact(contact: Contact){
        val Key = databaseReference.push().key
        if (Key != null){
            databaseReference.child(Key).setValue(contact)

        }

    }
    fun deleteContact(contactId: String){
        databaseReference.child(contactId).removeValue()
    }
//    fun getContactsflow(): Flow<List<Contact>> {
//
//    }

}