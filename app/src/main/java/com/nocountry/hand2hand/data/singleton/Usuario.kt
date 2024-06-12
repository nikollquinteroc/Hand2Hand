package com.nocountry.hand2hand.data.singleton

import com.nocountry.hand2hand.data.model.firebase_realtime.User

object Usuario {
    var name: String = ""
    var lastName: String = ""
    var birthDate: String = ""
    var phone: String = ""
    var e_mail: String = ""
    var address: String = ""
    var uid: String = ""

    fun initialize(user: User) {
        name = user.name
        lastName = user.lastName
        birthDate = user.birthDate
        phone = user.phone
        e_mail = user.e_mail
        address = user.address
        uid = user.uid
    }
}