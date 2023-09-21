package com.prueba.credibanco.core.valueObject

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

}


/*
sealed class Resource<out T> {

    class Loading<out T> : Resource<T>()

    data class Success<out T>(val data: T) : Resource<T>()

    data class Failure<out T>(val exception: Exception): Resource<T>()

}*/