package com.example.simplycontactlist.module

class UsersService : Service {
    override fun getUsers(): MutableList<User> {
        return UsersList().users
    }
}

interface Service {
    fun getUsers(): MutableList<User>
}