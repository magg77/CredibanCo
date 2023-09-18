package com.prueba.credibanco.data.provider.local.serviceLocal

import com.prueba.credibanco.data.provider.local.entity.AnnulmentEntity
import com.prueba.credibanco.data.provider.local.entity.AuthorizationEntity


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

class LocalDataSourceImpl : LocalDataSourceInterface{

    override suspend fun getAuthorizationAll(): List<AuthorizationEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAthorization(authorizationEntity: AuthorizationEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun annulmentTransaction(annulmentEntity: AnnulmentEntity) {
        TODO("Not yet implemented")
    }
}