package com.example.roclinics.data

data class UserData(
    var userId:String? = null,
    var firstName:String? = null,
    var lastName:String? = null,
    var phoneNumber:String? = null,
    var email:String? = null,
    var city:String? = null,
    var town:String? = null,
){
    fun toMap() = mapOf(
        "userId" to userId,
        "firstName" to firstName,
        "lastName" to lastName,
        "phoneNumber" to phoneNumber,
        "email" to email,
        "city" to city,
        "town" to town,
    )
}