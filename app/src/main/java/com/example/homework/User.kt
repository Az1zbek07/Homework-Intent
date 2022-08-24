package com.example.homework

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val lastName: String,
    val age: String
): Parcelable{
    override fun toString(): String {
        return  "Name: $name\nLast Name: $lastName\nAge: $age"
    }
}