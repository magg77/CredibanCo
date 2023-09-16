package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.core.valueObject.RetrofitClient
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse_to_mutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


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

class DataSourceRemoteImpl() :
    DataSourceRemoteInterface {

    /*override suspend fun authorization(
        authorization: String,
        authorizationRequest: AuthorizationRequest
    ): Resource.Success<List<AuthorizationResponse>> {

        var listWebService = mutableListOf<AuthorizationResponse>()

        withContext(Dispatchers.IO) {
            var authorizationResponse = webServiceInterface.authorizatioRrequestServer(authorizationRequest)
            listWebService = AuthorizationResponse_to_mutableList(authorizationResponse)
        }

        return Resource.Success(listWebService)

    }*/

    override suspend fun authorization(
        map: String,
        authorizationRequest: AuthorizationRequest
    ): Resource.Success<List<AuthorizationResponse>> {

        var listWebService = mutableListOf<AuthorizationResponse>()

        var mapa = mutableMapOf<String, String>(
            "Content-Type" to "application/json",
            "Authorization" to "Basic MDAwMTIzMDAwQUJD",
            "X-Platform" to "Android"
        )

        withContext(Dispatchers.IO) {
            //var authorizationResponse = RetrofitClient.webService.authorization(authorization, authorizationRequest)
            var authorizationResponse = RetrofitClient.webService.authorization2(mapa, authorizationRequest)
            listWebService = AuthorizationResponse_to_mutableList(authorizationResponse)
        }

        return Resource.Success(listWebService)

    }


}