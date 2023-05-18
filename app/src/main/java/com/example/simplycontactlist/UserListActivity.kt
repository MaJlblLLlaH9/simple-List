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
        val errorTextView = binding.errorTextView
        val recyclerView = binding.recyclerView
        recyclerView.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            viewModel.getUsers()
        }

        viewModel.init(object : UsersCallback {

            override fun provideUsers(adapter: UsersAdapter/*Что передавать???*/) = runOnUiThread {
                button.isEnabled = false
                progressBar.visibility = View.INVISIBLE
                binding.recyclerView.adapter = adapter
                recyclerView.visibility = View.VISIBLE
            }
//todo
//            override fun provideFailure(error: String) {
//                button.isEnabled = false
//                progressBar.visibility = View.INVISIBLE
//                errorTextView.visibility = View.VISIBLE
//                errorTextView.text = error
//            }
//
        }

        )


    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}