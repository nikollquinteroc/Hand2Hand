package com.nocountry.hand2hand.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.nocountry.hand2hand.model.Category
import com.nocountry.hand2hand.prueba.model.Contact
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class CategoryManager{

    fun addContact(user: Category){
        val key = FirebaseConnection.categoryDB.push().key
        if (key != null){
            FirebaseConnection.categoryDB.child(key).setValue(user)
        }
    }
    fun deleteContact(contactId: String) {
        FirebaseConnection.categoryDB.child(contactId).removeValue()
    }

    fun updateContact(contactId: String, updatedContact: Contact) {
        FirebaseConnection.categoryDB.child(contactId).setValue(updatedContact)
    }

    fun getContactsFlow(): Flow<List<Category>> {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword("yoni@mail.com" , "123456")


        val flow = callbackFlow {
            val listener = FirebaseConnection.categoryDB.addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val contacts = snapshot.children.mapNotNull {  snapshot ->
                        val contact = snapshot.getValue(Category::class.java)
                        snapshot.key?.let { contact?.copy(key = it) }
                    }

                    trySend(contacts).isSuccess
                }
                override fun onCancelled(error: DatabaseError) {
                    close(error.toException())
                }
            })
            awaitClose { FirebaseConnection.categoryDB.removeEventListener(listener) }
        }
        return flow
    }
}