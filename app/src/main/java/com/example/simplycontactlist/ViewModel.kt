package com.example.simplycontactlist

import com.example.simplycontactlist.module.UsersFailure


class ViewModel(private val model: Model) {

    private var callback: UserCallback? = null

    fun init(callback: UserCallback) {
        this.callback = callback
        model.init(object : ResultCallback {
            override fun provideSuccess(adapter: UsersAdapter) =
                callback.provideUsers(adapter)

            //todo
//            override fun provideError(error: UsersFailure) =
//                callback.provideUsers(error.getMessage())

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

interface UserCallback {
    fun provideUsers(adapter: UsersAdapter)
}

interface Model {

    fun getUsers()

    fun init(callback: ResultCallback)

    fun clear()
}

interface ResultCallback {
    fun provideSuccess(adapter: UsersAdapter)
//    fun provideError(error: UsersFailure)
}