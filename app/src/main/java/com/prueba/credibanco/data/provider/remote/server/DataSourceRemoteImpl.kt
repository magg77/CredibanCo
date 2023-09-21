package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import retrofit2.Response
import javax.inject.Inject


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

class DataSourceRemoteImpl @Inject constructor(private val webServiceInterface: WebServiceInterface) :
    DataSourceRemoteInterface {


    /*suspend fun old(
        authorization: String,
        authorizationRequest: AuthorizationRequest
    ): Resource<AuthorizationResponse> {

        var listWebService = mutableListOf<AuthorizationResponse>()
        var mapa = mutableMapOf<String, String>(
            "Content-Type" to "application/json",
            "Authorization" to "Basic MDAwMTIzMDAwQUJD",
            "X-Platform" to "Android"
        )

        withContext(Dispatchers.IO) {
            var responseBody = webServiceInterface.authorization(mapa, authorizationRequest)
            //var listWebService = AuthorizationResponse_to_mutableList(authorizationResponse)
            if (responseBody.isSuccessful) {
                var responseJson = responseBody
            }
        }

        return Resource.Success(listWebService)

    }*/

   /* suspend fun <T> authorization(apiCall: suspend () -> Response<T>): Resource<T> {
        TODO("Not yet implemented")
    }*/

    override suspend fun authorization(authorization: String, authorizationRequest: AuthorizationRequest): Response<AuthorizationResponse> {
        var listWebService = mutableListOf<AuthorizationResponse>()
        var mapa = mutableMapOf<String, String>(
            "Content-Type" to "application/json",
            "Authorization" to "Basic MDAwMTIzMDAwQUJD",
            "X-Platform" to "Android"
        )
        return webServiceInterface.authorization(mapa, authorizationRequest)
    }


}