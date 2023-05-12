package com.example.simplycontactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplycontactlist.databinding.ItemUserBinding
import com.example.simplycontactlist.module.Service
import com.example.simplycontactlist.module.User

class UsersAdapter(service: Service) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var users = service.getUsers()

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
            binding.userNameTextView.text = user.getUserName()
            binding.userAboutTextView.text = user.getUserAbout()
            binding.photoImageView.setImageResource(user.getUserPhoto());
        }
    }
}