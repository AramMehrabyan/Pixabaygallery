package com.aram.mehrabyan.utils.model

sealed class ActionResult<out R> {

    data class Success<out T>(val data: T) : ActionResult<T>()
    data class Error(val exception: Exception? = null) : ActionResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
