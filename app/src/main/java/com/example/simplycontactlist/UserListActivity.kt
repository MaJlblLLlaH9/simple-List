package com.example.simplycontactlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplycontactlist.databinding.ActivityUserListBinding
import com.example.simplycontactlist.module.UserApp
import com.example.simplycontactlist.module.UsersList
import com.example.simplycontactlist.module.UsersService
import com.example.simplycontactlist.module.ViewModel


class UserListActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserListBinding
    private lateinit var adapter: UsersAdapter
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as UserApp).viewModel
        adapter = UsersAdapter(UsersService())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}