package com.example.simplycontactlist

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.simplycontactlist.databinding.ActivityUserListBinding
import com.example.simplycontactlist.module.User

class UserListActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserListBinding
    private val adapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter(binding)
    }

    fun setupAdapter(binding: ActivityUserListBinding) {
        binding.recyclerView.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.adding_user, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.EnterNameEditTextView)
        val about = view.findViewById<TextView>(R.id.EnterAboutEditTextView)
        val saveButton = view.findViewById<Button>(R.id.AddButtonView)
        val alertDialog = builder.create()

        binding.AddButtonView.setOnClickListener {
            alertDialog.show()
        }
        saveButton.setOnClickListener {
            val user = User(name.text.toString(), about.text.toString())
            val users= mutableListOf(user)
            adapter.setupUsersData(users)
            alertDialog.dismiss()
        }
    }
}