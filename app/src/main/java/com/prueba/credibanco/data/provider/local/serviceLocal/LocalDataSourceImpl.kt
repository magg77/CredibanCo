package com.prueba.credibanco.data.provider.local.serviceLocal

import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.local.entity.AnnulmentEntity
import com.prueba.credibanco.data.provider.local.entity.AuthorizationEntity
import javax.inject.Inject


/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: magg77
 * @DATE: 17,septiembre,2023
 * @COMPAN:
 * @EMAIL: escenariopaloma@gmail.com
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su propietario y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 *
 */

class LocalDataSourceImpl @Inject constructor(private val localserviceinterfaceDao: LocalServiceInterface_Dao) :
    LocalDataSourceInterface {

    override suspend fun getAuthorizationAll(): Resource<List<AuthorizationEntity>> {
        return Resource.Success(localserviceinterfaceDao.getAuthorizationAll())
    }

    override suspend fun insertAthorization(authorizationEntity: AuthorizationEntity) {
        localserviceinterfaceDao.insertAthorization(authorizationEntity)
    }


    override suspend fun annulmentTransaction(annulmentEntity: AnnulmentEntity) {
        localserviceinterfaceDao.annulmentTransaction(annulmentEntity)
    }
}