package com.example.simplycontactlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.simplycontactlist.databinding.ActivityUserListBinding
import com.example.simplycontactlist.module.UserApp


class UserListActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserListBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = (application as UserApp).viewModel
        val button = binding.buttonView
        val progressBar = binding.progressBar
        val recyclerView = binding.recyclerView
        recyclerView.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            viewModel.getUsers()

        }

        viewModel.init(object : UserCallback {

            override fun provideUsers(adapter: UsersAdapter) = runOnUiThread {
                button.isEnabled = false
                progressBar.visibility = View.INVISIBLE
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