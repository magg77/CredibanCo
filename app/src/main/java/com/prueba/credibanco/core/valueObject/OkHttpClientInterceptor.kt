package com.prueba.credibanco.core.valueObject

import okhttp3.Interceptor
import okhttp3.Response


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

class OkHttpClientInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        /*val request = chain.request().newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("Authorization", "Basic MDAwMTIzMDAwQUJD")
            .addHeader("Platform", "Android")
            .build()*/

        /*val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .addHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .build()*/

        val request = chain.request().newBuilder().build()

        return chain.proceed(request)
    }
}

/*object OkHttpClientInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestWithHeader = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "")
            .addHeader(
                "Authorization", ""
            )
            .build()
        return chain.proceed(requestWithHeader)
    }
}*/
