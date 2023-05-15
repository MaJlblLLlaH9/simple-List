package com.example.simplycontactlist

import com.example.simplycontactlist.module.Service
import com.example.simplycontactlist.module.User
import com.example.simplycontactlist.module.UsersFailure
import com.example.simplycontactlist.module.UsersService
import java.lang.Error


class ViewModel(private val model: Model) {

    private var callback: TextCallback? = null

    fun init(callback: TextCallback) {
        this.callback = callback
        model.init(object : ResultCallback {
            override fun provideSuccess(service: Service) =
                callback.provideUsers(service)

//            override fun provideError(error: Service) =
//                callback.provideUsers(error)

        })
    }

    fun getUsers() {
        model.getUsers()
    }

    fun clear() {
        callback = null
        model.clear()
    }
}

interface TextCallback {
    fun provideUsers(service: Service)
}

interface Model {

    fun getUsers()

    fun init(callback: ResultCallback)

    fun clear()
}

interface ResultCallback {
    fun provideSuccess(service: Service)
//    fun provideError(service: Service)
}