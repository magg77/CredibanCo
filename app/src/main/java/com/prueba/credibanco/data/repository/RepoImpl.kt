package com.prueba.credibanco.data.repository

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.local.entity.AnnulmentEntity
import com.prueba.credibanco.data.provider.local.entity.AuthorizationEntity
import com.prueba.credibanco.data.provider.local.serviceLocal.LocalDataSourceInterface
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse
import com.prueba.credibanco.data.provider.remote.server.DataSourceRemoteInterface
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

class RepoImpl @Inject constructor(
    private val dataSourceRemote: DataSourceRemoteInterface,
    private val localDataSourceInterface: LocalDataSourceInterface
) :
    RepoInterface {

    override suspend fun authorization_Repo(
        auth: String,
        authorizationRequest: AuthorizationRequest
    ): Resource<List<AuthorizationResponse>> {
        return dataSourceRemote.authorization(auth, authorizationRequest)
    }



    override suspend fun getAuthorizationAll_Repo(): Resource<List<AuthorizationEntity>> = localDataSourceInterface.getAuthorizationAll()

    override suspend fun insertAthorization_Repo(authorizationEntity: AuthorizationEntity) {
        localDataSourceInterface.insertAthorization(authorizationEntity)
    }

    override suspend fun annulmentTransaction_Repo(annulmentEntity: AnnulmentEntity) {
        localDataSourceInterface.annulmentTransaction(annulmentEntity)
    }


}