package com.example.simplycontactlist.module

import com.example.simplycontactlist.model.ResourceManager

class User(private val name: String, private val about: String, private val photo: Int) {


//    private fun getUserUi() = "$photo$name\n$about"

    fun getUserName(): String {
        return name
    }

    fun getUserAbout(): String {
        return about
    }

    fun getUserPhoto(): Int {
        return photo
    }

//    fun map(callback: DataCallback) = callback.run {
//        provideData(getUserUi())
//    }
}

interface UsersFailure {
    fun getMessage(): MutableList<User>
}

class NoData(private val resourceManager: ResourceManager) : UsersFailure {
    override fun getMessage(): MutableList<User> = UsersList().users
}

//
class ServiceUnavailable(private val resourceManager: ResourceManager) : UsersFailure {
    override fun getMessage(): MutableList<User> = UsersList().users

}





