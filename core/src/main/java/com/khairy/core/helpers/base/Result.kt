package com.khairy.core.helpers.base

sealed class MyResult {
    class Success<T>(data: T) : MyResult()
    class Failed(message: String?) : MyResult()
    object NetworkError : MyResult()
    object ServerError : MyResult()
}