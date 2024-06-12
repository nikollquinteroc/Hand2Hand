package com.nocountry.hand2hand.data

import com.nocountry.hand2hand.data.model.firebase_realtime.User

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