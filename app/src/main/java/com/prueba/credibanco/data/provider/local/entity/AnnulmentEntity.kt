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

@Entity(tableName = "AnnulmentEntity")
data class AnnulmentEntity(
    @PrimaryKey val receipId: Long = 0,
    @ColumnInfo val rrn: String = "",
    @TypeConverters(ConvertersDateRoom::class)
    @ColumnInfo val dateAnnulment: Date
)