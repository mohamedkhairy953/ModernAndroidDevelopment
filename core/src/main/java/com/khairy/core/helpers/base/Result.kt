package com.khairy.core.helpers.base

sealed class MyResult {
    class Success<T>(val data: T) : MyResult()
    class Failed(message: String?) : MyResult()
    object NetworkError : MyResult()
    object ServerError : MyResult()
    object Loading : MyResult()
    object Idle : MyResult()
}