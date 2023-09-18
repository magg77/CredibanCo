package com.prueba.credibanco.core.valueObject

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prueba.credibanco.data.provider.local.entity.AnnulmentEntity
import com.prueba.credibanco.data.provider.local.entity.AuthorizationEntity
import com.prueba.credibanco.data.provider.local.entity.ConvertersDateRoom
import com.prueba.credibanco.data.provider.local.serviceLocal.LocalServiceInterface_Dao


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

@Database(entities = [AuthorizationEntity::class, AnnulmentEntity::class], version = 1, exportSchema = true)
@TypeConverters(ConvertersDateRoom::class)
abstract class AppDatabaseRoom: RoomDatabase() {

    abstract fun transactionDao(): LocalServiceInterface_Dao

}