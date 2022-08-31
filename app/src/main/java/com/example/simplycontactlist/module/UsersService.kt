
package com.example.simplycontactlist.module

class UsersService {
    fun getUsers(): MutableList<User> {
        return UsersList().users
    }
}
