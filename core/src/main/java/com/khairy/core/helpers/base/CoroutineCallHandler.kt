package com.khairy.core.helpers.base


import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.CancellationException

class CoroutineCallHandler {
    companion object {
        suspend fun <T> call(serviceMethod: suspend () -> T): MyResult {
            return try {
                return MyResult.Success(serviceMethod())
            } catch (e: HttpException) {
                MyResult.Failed(e.message())
            } catch (e: IOException) {
                MyResult.NetworkError
            } catch (e: Exception) {
                MyResult.ServerError
            }
        }

    }


}