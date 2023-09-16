package com.prueba.credibanco.core.valueObject

import com.google.gson.GsonBuilder
import com.prueba.credibanco.BuildConfig
import com.prueba.credibanco.data.provider.remote.server.WebServiceInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: magg77
 * @DATE: 15,septiembre,2023
 * @COMPAN:
 * @EMAIL: escenariopaloma@gmail.com
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su propietario y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 *
 */

object RetrofitClient {

    val webService by lazy {

        val TIMEOUT: Long = 3 // ms
        val BASE_URL = "http://10.0.2.2:8080/api/payments/"      //mobile device emulator
        //val BASE_URL = "http://192.168.1.105:8080/api/payments/"   //physical mobile device

        var interceptor = Interceptor { chain ->
            /*val request = chain.request().newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("Authorization", "Basic")
                .addHeader("X-Platform", "Android")
                .build()*/
            val request = chain.request().newBuilder().build()
            chain.proceed(request)
        }

        //forma 1: HttpLoggingInterceptor
        /*val logging1 = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
            //logging.redactHeader("Authorization")
            //logging.redactHeader("Cookie")
        }*/

        //forma 2: HttpLoggingInterceptor
        var logging2 = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
            if (BuildConfig.DEBUG) {
                this.level = HttpLoggingInterceptor.Level.BODY
                //this.redactHeader("Authorization");
                //this.redactHeader("Cookie")
            }
        }

        val client: OkHttpClient = OkHttpClient.Builder()
            //.addInterceptor(OkHttpClientInterceptor())
            .addInterceptor(interceptor)
            .addInterceptor(logging2)
            .callTimeout(3, TimeUnit.SECONDS)
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setDateFormat("aaaa-MM-dd'T'HH:mm:ss")
            .setLenient()
            .create()

        Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())
            )
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(WebServiceInterface::class.java)

    }

}