package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import retrofit2.Response

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

interface DataSourceRemoteInterface {

    suspend fun authorization(authorization: String, authorizationRequest: AuthorizationRequest): Response<AuthorizationResponse>

    /*suspend fun authorization(
        authorization: String,
        authorizationRequest: AuthorizationRequest
    ): Resource.Success<List<AuthorizationResponse>>*/

    /*suspend fun <T> authorization(
        authorization: String,
        authorizationRequest: AuthorizationRequest
    ): Resource<T>*/

    //suspend fun <T> authorization(apiCall: suspend () -> Response<T>): Resource<T>



}