package com.nocountry.hand2hand.domain

import com.nocountry.hand2hand.data.model.firebase.State
import kotlinx.coroutines.flow.Flow

interface StateRepository {
    suspend fun getStates() : Flow<List<State>>
}