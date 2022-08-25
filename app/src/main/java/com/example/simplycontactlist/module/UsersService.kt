package com.example.simplycontactlist.module

import com.example.simplycontactlist.databinding.AddingUserBinding

class UsersService {
    var users = mutableListOf<User>()
    init{
    users = (1..7).map{ User(
        id= it,
        name = "Jay Price",
        about = "Price financial"
    )
    }.toMutableList()
    }


}