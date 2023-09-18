package com.prueba.credibanco.data.provider.local.serviceLocal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

@Dao
interface LocalServiceInterface_Dao {

    @Query("SELECT * FROM AuthorizationEntity")
    suspend fun getAuthorizationAll(): List<AuthorizationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAthorization(authorizationEntity: AuthorizationEntity)

    @Delete
    suspend fun annulmentTransaction(annulmentEntity: AnnulmentEntity)

}