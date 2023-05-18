package com.example.simplycontactlist.module

import com.example.simplycontactlist.R
import com.example.simplycontactlist.model.ResourceManager

interface UsersFailure {
    fun getMessage(): String
}

class NoData(private val resourceManager: ResourceManager) : UsersFailure {
    override fun getMessage() = resourceManager.getMessage(R.string.noData)
}
//class ServiceUnavailable(private val resourceManager: ResourceManager) : UsersFailure {
//    override fun getMessage(): String = resourceManager.getMessage(R.string.serviceUnavailable)
//
//}