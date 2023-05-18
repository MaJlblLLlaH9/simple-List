package com.example.simplycontactlist.module

import com.example.simplycontactlist.model.ResourceManager

class User(private val name: String, private val about: String, private val photo: Int) {

    fun getUserName(): String {
        return name
    }

    fun getUserAbout(): String {
        return about
    }

    fun getUserPhoto(): Int {
        return photo
    }
}








