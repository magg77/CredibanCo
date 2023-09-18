package com.prueba.credibanco.data.provider.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date


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

@Entity(tableName = "AuthorizationEntity")
data class AuthorizationEntity (
    @PrimaryKey val id: Long,
    @ColumnInfo val commerceCode: String,
    @ColumnInfo val terminalCode: String,
    @ColumnInfo val amount: String,
    @ColumnInfo val card: String,
    @TypeConverters(ConvertersDateRoom::class)
    @ColumnInfo val dateAuthorization: Date
)