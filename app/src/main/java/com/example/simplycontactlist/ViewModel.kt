package com.example.simplycontactlist

import com.example.simplycontactlist.module.UsersFailure


class ViewModel(private val model: Model) {

    private var callback: UsersCallback? = null

    fun init(callback: UsersCallback) {
        this.callback = callback
        model.init(object : ResultCallback {
            override fun provideSuccess(adapter: UsersAdapter) =
                callback.provideUsers(adapter)

            //todo
//            override fun provideError(/*Что передавать???*/error: UsersFailure) =
//                callback.provideFailure(error.getMessage())

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

interface UsersCallback {
    fun provideUsers(adapter: UsersAdapter)
//todo    fun provideFailure(error: String)
}

interface Model {

    fun getUsers()

    fun init(callback: ResultCallback)

    fun clear()
}

interface ResultCallback {
    fun provideSuccess(adapter: UsersAdapter)
   //todo  fun provideError(error: UsersFailure)
}