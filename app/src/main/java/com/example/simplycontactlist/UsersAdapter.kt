package com.example.simplycontactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplycontactlist.databinding.ItemUserBinding
import com.example.simplycontactlist.module.User
import com.example.simplycontactlist.module.UsersService

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var users = UsersService().getUsers()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = users[position]
        holder.bindItem(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UsersViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(user: User) {
            binding.userNameTextView.text = user.name
            binding.userAboutTextView.text = user.about
            binding.photoImageView.setImageResource(R.drawable.ic_user_avatar);
        }
    }
}