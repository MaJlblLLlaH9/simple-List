package com.example.simplycontactlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplycontactlist.databinding.ActivityUserListBinding


class UserListActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserListBinding
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UsersAdapter()

        binding.recyclerView.adapter = adapter
    }
}