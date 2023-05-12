package com.example.simplycontactlist.model

import android.content.Context
import com.example.simplycontactlist.module.Model
import com.example.simplycontactlist.module.ResultCallback
import com.example.simplycontactlist.module.UsersService

class TestModel(resourceManager: ResourceManager) : Model {
    private var callback: ResultCallback? = null
    private var count = 0
    override fun chooseDataSource(cached: Boolean) {

    }

    override fun getList() {

    }

    override fun init(callback: ResultCallback) {
        this.callback = callback
    }

    override fun clear() {
        callback = null
    }

}

interface ResourceManager {
    fun getString(stringResId: Int): String
}

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringResId: Int) = context.getString(stringResId)

}