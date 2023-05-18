package com.example.simplycontactlist.module

import com.example.simplycontactlist.R

class UsersList {
    var users = mutableListOf<User>(
        User("Jay Price", "Price Financial, Financial Planner", R.drawable.photo1),
        User("Jen Olson", "Be you Fitness", R.drawable.photo2),
        User("Jennifer Williams", "Jennifer Williams, Makeup Artist", R.drawable.photo3),
        User("Joann Short", "Venture Capitalist", R.drawable.photo4),
        User("Kevin Jones", "Living Disigns, Head Architect", R.drawable.photo5),
        User("Lindsay Adams", "SpotAnalyst, Director of Marketing", R.drawable.photo6),
        User(
            "Marco Rodriguez",
            "Little Mexico, Owner of General Manifest Affairs",
            R.drawable.photo3
        )
    )

    companion object {
        val emptyUserList = emptyList<User>()
    }
}