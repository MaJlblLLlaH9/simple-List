package com.example.simplycontactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplycontactlist.databinding.ItemUserBinding
import com.example.simplycontactlist.module.User
import com.github.javafaker.Faker

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    val faker = Faker.instance()
    private var users = mutableListOf<User>(
        User(faker.name().name(), faker.programmingLanguage().name()),
        User(faker.name().name(), faker.programmingLanguage().name()),
    )

    fun setupUsersData(user: List<User>) {
        users.addAll(user)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bindItem(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(user: User) {
            binding.userNameTextView.text = user.name
            binding.userAboutTextView.text = user.about

        }
    }
}
