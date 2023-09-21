package com.prueba.credibanco.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prueba.credibanco.core.valueObject.Resource
import com.prueba.credibanco.data.provider.local.entity.AnnulmentEntity
import com.prueba.credibanco.data.provider.local.entity.AuthorizationEntity
import com.prueba.credibanco.data.provider.remote.model.AuthorizationRequest
import com.prueba.credibanco.data.provider.remote.model.AuthorizationResponse


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

interface RepoInterface {


    //REMOTE SERVER
    suspend fun authorization_Repo(
        auth: String,
        authorizationRequest: AuthorizationRequest
    ): Resource<AuthorizationResponse>


    //LOCAL BD
    suspend fun getAuthorizationAll_Repo(): Resource<List<AuthorizationEntity>>
    suspend fun insertAthorization_Repo(authorizationEntity: AuthorizationEntity)

    suspend fun annulmentTransaction_Repo(annulmentEntity: AnnulmentEntity)

}