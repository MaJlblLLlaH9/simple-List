package com.example.simplycontactlist.module

import androidx.annotation.DrawableRes

class ViewModel(private val model: Model) {

    private var dataCallback: DataCallback? = null

    fun init(callback: DataCallback) {
        dataCallback = callback
        model.init(object : ResultCallback {
            override fun provide(user: User) {
                dataCallback?.let { user.map(it) }
            }

        })
    }
    fun clear(){
        dataCallback = null
        model.clear()
    }
}


interface DataCallback {
    fun provideName(name: String)
    fun provideAbout(text: String)
    fun providePhoto(photo: Int)
}

interface Model {
    fun chooseDataSource(cached: Boolean)

    fun getList()

    fun init(callback: ResultCallback)

    fun clear()
}

interface ResultCallback {
    fun provide(user: User)
}