//package com.example.simplycontactlist.module
//
//import android.content.Context
//import android.widget.Toast
//import com.github.javafaker.Faker
//
//class UsersService {
//    var users = mutableListOf<User>()
//    val faker = Faker.instance()
//    init{
//    users = (1..10).map{ User(
//        name = faker.name().name(),
//        about = faker.programmingLanguage().name()
//    )
//    }.toMutableList()
//    }
//    fun deleteUser(user: User) {
//        val indexToDelete = users.indexOfFirst { it.id == user.id }
//        if (indexToDelete != -1) {
//            users.removeAt(indexToDelete)
//        }
//    }
//}