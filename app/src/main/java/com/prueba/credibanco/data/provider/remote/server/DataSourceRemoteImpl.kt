package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse_to_mutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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

    override suspend fun authorization(
        authorization: String,
        authorizationRequest: AuthorizationRequest
    ): Resource.Success<List<AuthorizationResponse>> {

        var listWebService = mutableListOf<AuthorizationResponse>()

        withContext(Dispatchers.IO) {
            var authorizationResponse = webServiceInterface.authorizatioRrequestServer(authorizationRequest)
            listWebService = AuthorizationResponse_to_mutableList(authorizationResponse)
        }

        return Resource.Success(listWebService)

    }


}