package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: magg77
 * @DATE: 14,septiembre,2023
 * @COMPAN:
 * @EMAIL: escenariopaloma@gmail.com
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su propietario y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 *
 */

interface WebServiceInterface {

   /* @Headers(
        "Authorization", "fdfd",
        "Content-type", "application/json",
        "Platform", "Android"
    )*/

    //metodo funciona ok: HEADERS STATICS IN INTERCEPTOR
    @POST("authorization")
    suspend fun authorizatioRrequestServer(
        @Body authorizationRequest: AuthorizationRequest
    ): Response<AuthorizationResponse>

    //metodo funciona ok: HEADERS DYNAMIC WITH @HeaderMap
    @POST("authorization")
    suspend fun authorization(
        @HeaderMap headers: Map<String, String>,
        @Body authorizationRequest: AuthorizationRequest
    ): Response<AuthorizationResponse>



}