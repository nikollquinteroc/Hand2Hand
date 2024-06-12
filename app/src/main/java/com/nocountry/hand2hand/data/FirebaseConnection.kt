package com.nocountry.hand2hand.data

import com.google.firebase.database.FirebaseDatabase

class FirebaseConnection {
    companion object{
        val userDB = FirebaseDatabase.getInstance().reference.child("user")
        val categoryDB = FirebaseDatabase.getInstance().reference.child("category")
        val subcategoryDB = FirebaseDatabase.getInstance().reference.child("subcategory")
        val publicationDB = FirebaseDatabase.getInstance().reference.child("publication")
        val locationDB = FirebaseDatabase.getInstance().reference.child("location")
        val messageDB = FirebaseDatabase.getInstance().reference.child("message")
        val contactDB = FirebaseDatabase.getInstance().reference.child("contacts")
    }
}