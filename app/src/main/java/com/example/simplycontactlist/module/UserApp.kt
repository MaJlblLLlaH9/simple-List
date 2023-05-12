package com.example.simplycontactlist.module

import android.app.Application
import com.example.simplycontactlist.model.BaseResourceManager
import com.example.simplycontactlist.model.TestModel

class UserApp : Application() {
    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(TestModel(BaseResourceManager(this)))
    }
}
