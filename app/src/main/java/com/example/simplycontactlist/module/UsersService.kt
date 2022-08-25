package com.example.simplycontactlist.module

import com.example.simplycontactlist.databinding.AddingUserBinding
import com.github.javafaker.Faker

class UsersService {
    var users = mutableListOf<User>()
    val faker = Faker.instance()
    init{
    users = (1..10).map{ User(
        id= it,
        name = faker.name().name(),
        about = faker.programmingLanguage().name()
    )
    }.toMutableList()
    }
}