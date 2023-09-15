package com.prueba.credibanco.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.prueba.credibanco.data.provider.remote.server.WebServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitNetworkModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        //build client
        val TIMEOUT: Long = 30
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    //create request
                    chain.request()
                        .newBuilder()
                        //add headers to the request builder
                        .also {
                            it.addHeader("Content-type", "application/json")
                            it.addHeader("Authorization", "Basic MDAwMTIzMDAwQUJD")
                        }.build()

                )
            }
            //add timeouts, logging
            .also { okHttpClient ->

                okHttpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                okHttpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS)
                //log if in debugging phase
                /*if (BuildConfig.DEBUG) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {

                        level = HttpLoggingInterceptor.Level.BODY
                    }

                    okHttpClient.addInterceptor(httpLoggingInterceptor)
                }*/
            }
            .build()
    }

    @Provides
    @Singleton
    fun getGson(): Gson {
        //serializeNulls():  is used to specify that even null values will be serialized. By default, Gson omits the null fields
        //setLenient():      makes the Gson parser liberal in what it accepts. By default, it is strict and only accepts JSON.
        return GsonBuilder().serializeNulls().setLenient().create()
    }

    @Singleton
    @Provides
    fun provideNetworkRetrofitModule(okHttpClient: OkHttpClient): Retrofit {

        //val BASE_URL = "http://localhost:8080/api/payments/"
        val BASE_URL = "http://10.0.2.2:8080/api/payments/"      //mobile device emulator
        //val BASE_URL = "http://127.0.0.1:8080/api/payments/"
        //val BASE_URL = "http://192.168.1.105:8080/api/payments/"   //physical mobile device

        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())
            )
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideWebServiceInterface(retrofit: Retrofit): WebServiceInterface {
        return  retrofit.create(WebServiceInterface::class.java)
    }
    /*fun provideWebServiceInterface(retrofit: Retrofit): WebServiceInterface = retrofit.create(
        WebServiceInterface::class.java
    )*/


}