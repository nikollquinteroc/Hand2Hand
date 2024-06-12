package com.nocountry.hand2hand.data.repository

import android.content.ContentValues
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.nocountry.hand2hand.data.model.firebase_firestore.State
import com.nocountry.hand2hand.domain.StateRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class StateRepositoryImpl(val firebase: FirebaseFirestore) : StateRepository {
    override suspend fun getStates(): Flow<List<State>> = callbackFlow {
        firebase.collection("state")
            .get()
            .addOnSuccessListener { result ->
                val states = mutableListOf<State>()
                for (state in result.documents) {
                    state.toObject(State::class.java)?.let { states.add(it) }
                }
                trySend(states)
            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "Error al obtener los estados: ", exception)
            }

        awaitClose { }
    }
}