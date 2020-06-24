package com.khairy.core.helpers.base

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.CancellationException

class CoroutineCallHandler {
    companion object {
      /*  suspend fun <T> call(serviceMethod: suspend () -> BaseResponse<T>): BaseResponse<T> {
            return try {
                return serviceMethod()
            } catch (e: HttpException) {
                e.getResponse(BaseResponse<T>(null, null))
            } catch (e: IOException) {
                BaseResponse(listOf(), null, false, com.khairy.core.helpers.base.IO_EXCEPTION_CODE)
            } catch (e: ServerDataNullException) {
                BaseResponse(listOf(), null, false, com.khairy.core.helpers.base.SERVER_DATA_NULL_EXCEPTION_CODE)
            } catch (e: CancellationException) {
                BaseResponse(null, null, false, com.khairy.core.helpers.base.CANCELLED_EXCEPTION_CODE)
            } catch (e: Exception) {
                BaseResponse(null, null, false, com.khairy.core.helpers.base.SERVER_EXCEPTION_CODE)
            }
        }*/

    }


}