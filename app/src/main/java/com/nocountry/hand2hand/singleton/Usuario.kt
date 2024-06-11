package com.nocountry.hand2hand.singleton

import com.nocountry.hand2hand.model.User

object Usuario {
    var name: String = ""
    var lastName: String = ""
    var birthDate: String = ""
    var phone: String = ""
    var e_mail: String = ""
    var address: String = ""
    var uid: String = ""

    fun initialize(user: User) {
        this.name = user.name
        this.lastName = user.lastName
        this.birthDate = user.birthDate
        this.phone = user.phone
        this.e_mail = user.e_mail
        this.address = user.address
        this.uid = user.uid
    }
}