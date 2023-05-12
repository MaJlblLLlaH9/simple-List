package com.example.simplycontactlist.module

import androidx.annotation.DrawableRes

class User(private val name: String, private val about: String, private val photo: Int) {

    fun getUserName(): String {
        return name
    }

    fun getUserAbout(): String {
        return about
    }

    fun getUserPhoto(): Int {
        return photo
//    private fun getUserUi() = "$photo" + "$name" + "$about"

    }

    //
    fun map(callback: DataCallback) = callback.run {
        provideName(getUserName())
        provideAbout(getUserAbout())
        providePhoto(getUserPhoto())
    }
}






