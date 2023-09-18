package com.prueba.credibanco.data.provider.local.entity

import androidx.room.TypeConverter
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

class ConvertersDateRoom @Inject constructor() {

    @TypeConverter
    fun fromTimestamp(value: Long?): java.util.Date? {
        return value?.let { java.util.Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: java.util.Date?): Long? {
        return date?.time?.toLong()
    }



    /*@TypeConverter
    fun TimestampToDate(timeStamp: Long?): String? {
        return timeStamp?.let { FORMATTER.format(timeStamp) }
        //return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(timeStamp: String?): Long? {
        return timeStamp?.let { FORMATTER.parse(it)?.time }
        //return date?.time?.toLong()
    }


    companion object {
        var FORMATTER = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).apply {
            this.timeZone = TimeZone.getTimeZone("UTC")
        }
    }*/



}