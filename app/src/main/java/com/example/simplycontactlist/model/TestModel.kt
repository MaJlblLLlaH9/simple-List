package com.example.simplycontactlist.model

import android.content.Context
import com.example.simplycontactlist.Model
import com.example.simplycontactlist.ResultCallback
import com.example.simplycontactlist.UsersAdapter
import com.example.simplycontactlist.module.NoData
import com.example.simplycontactlist.module.ServiceUnavailable
import com.example.simplycontactlist.module.UsersService

class TestModel(resourceManager: ResourceManager) : Model {
    private var callback: ResultCallback? = null

    //    private var count = 0
    private val noData = NoData(resourceManager)
//    private val serviceUnavailable = ServiceUnavailable(resourceManager)

    override fun getUsers() {
        Thread {
            Thread.sleep(1000)
            callback?.provideSuccess(UsersAdapter(UsersService()))
// todo           callback?.provideError(noData)
        }.start()
    }

    override fun init(callback: ResultCallback) {
        this.callback = callback
    }

    override fun clear() {
        this.callback = null
    }
}

interface ResourceManager {
    fun getString(stringResId: Int): String
}

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringResId: Int) = context.getString(stringResId)

}