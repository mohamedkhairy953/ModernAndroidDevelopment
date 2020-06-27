package com.khairy.core.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.serializationConverterFactory
import com.khairy.core.BuildConfig
import com.khairy.core.helpers.retrofit.MyServiceInterceptor
import com.khairy.core.helpers.retrofit.NullOnEmptyConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.json.JSON
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideServiceInterceptor(): Interceptor {
        return MyServiceInterceptor()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        } else
            HttpLoggingInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        myServiceInterceptor: MyServiceInterceptor,
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(myServiceInterceptor)
        builder.connectTimeout(120, TimeUnit.SECONDS)
        builder.readTimeout(120, TimeUnit.SECONDS)
        builder.addNetworkInterceptor(interceptor)
        return builder.build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(ScalarsConverterFactory.create()) //the ordering is importing, we must but ScalersConverter before Gson
            .addConverterFactory(serializationConverterFactory(contentType, JSON))
            .build()
    }

}