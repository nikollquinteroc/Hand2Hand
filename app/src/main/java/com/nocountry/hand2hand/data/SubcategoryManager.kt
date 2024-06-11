package com.nocountry.hand2hand.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.nocountry.hand2hand.model.Category
import com.nocountry.hand2hand.model.SubCategory
import com.nocountry.hand2hand.prueba.model.Contact
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class SubcategoryManager {


    fun addContact(user: SubCategory){
        val key = FirebaseConnection.subcategoryDB.push().key
        if (key != null){
            FirebaseConnection.subcategoryDB.child(key).setValue(user)
        }
    }
    fun deleteContact(contactId: String) {
        FirebaseConnection.subcategoryDB.child(contactId).removeValue()
    }

    fun updateContact(contactId: String, updatedContact: SubCategory) {
        FirebaseConnection.subcategoryDB.child(contactId).setValue(updatedContact)
    }

    fun getContactsFlow(keyCategoria: String = ""): Flow<List<SubCategory>> {
        FirebaseAuth.getInstance()//ACA SE QUITA ESTA LINEA UNA VEZ QUE EL USUARIO INICIE SESION, SE DEJO SOLAMENTE PARA PODER TRABAJARLO AL MOMENTO DE DESARROLLAR PARA AGILIZAR
            .signInWithEmailAndPassword("yoni@mail.com" , "123456")


        val flow = callbackFlow {
            val listener = FirebaseConnection.subcategoryDB.addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val contacts = snapshot.children.mapNotNull {  snapshot ->
                        val contact = snapshot.getValue(SubCategory::class.java)
                        snapshot.key?.let { contact?.copy(key = it) }
                    }

                    trySend(contacts.filter{it.ctegoryKey == keyCategoria}).isSuccess
                }
                override fun onCancelled(error: DatabaseError) {
                    close(error.toException())
                }
            })
            awaitClose { FirebaseConnection.subcategoryDB.removeEventListener(listener) }
        }
        return flow
    }
}