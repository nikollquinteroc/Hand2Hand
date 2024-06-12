package com.nocountry.hand2hand.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.values
import com.nocountry.hand2hand.model.User

class UserManager{
//    fun getUser(): User {
//        FirebaseConnection.userDB.values()
//    }

    fun addUser(user: User){
        val key = FirebaseConnection.userDB.push().key
        if (key != null){
            FirebaseConnection.userDB.child(key).setValue(user)
        }
    }

//    fun updateUseruUser: User){
//        val Key = databaseReference.push().key
//        if (Key != null){
//            databaseReference.child(Key).setValue(contact)
//
//        }
//
//    }
//    fun deleteUser(contactId: String){
//        databaseReference.child(contactId).removeValue()
//    }
}