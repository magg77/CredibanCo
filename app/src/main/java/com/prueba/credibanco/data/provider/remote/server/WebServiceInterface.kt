package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


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



    //metodo funciona ok
    @POST("authorization")
    suspend fun authorizatioRrequestServer(
        @Body authorizationRequest: AuthorizationRequest
    ): AuthorizationResponse

    /*@POST("authorization")
    suspend fun authorization(
        @Header("Authorization") authorization: String,
        @Body authorizationRequest: AuthorizationRequest
    ): AuthorizationResponse*/



}