package com.example.simplycontactlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.simplycontactlist.databinding.ActivityUserListBinding
import com.example.simplycontactlist.module.Service
import com.example.simplycontactlist.module.UserApp
import com.example.simplycontactlist.module.UsersService


class UserListActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserListBinding
    private lateinit var adapter: UsersAdapter
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = (application as UserApp).viewModel
        val button = binding.buttonView
        val progressBar = binding.progressBar
        val recyclerView = binding.recyclerView
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.visibility = View.INVISIBLE
            viewModel.getUsers()

        }

        viewModel.init(object : TextCallback {

            override fun provideUsers(user: Service) = runOnUiThread {
                button.isEnabled = false
                progressBar.visibility = View.INVISIBLE
                adapter = UsersAdapter(UsersService())
                binding.recyclerView.adapter = adapter
                recyclerView.visibility = View.VISIBLE
            }

        }
        )


    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}