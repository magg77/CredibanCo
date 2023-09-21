package com.prueba.credibanco.data.provider.remote.server

import com.prueba.credibanco.core.valueObject.Resource
import retrofit2.Response


/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: magg77
 * @DATE: 20,septiembre,2023
 * @COMPAN:
 * @EMAIL: escenariopaloma@gmail.com
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su propietario y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 *
 */

abstract class ApiResponse {

    suspend fun <T> responseNetwork(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                }
                return error("${response.code()} ${response.message()}")
            } else {
                return error("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    /*suspend fun <T> responseNetwork(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                }
            }
            var responceCod = response.body()
            var mens = "${response.code()} ${response.message()}"

            return error("${response.code()} ${response.message()}")

        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }*/



    private fun <T> error(errorMessage: String): Resource<T> = Resource.Error("$errorMessage")
}