package com.prueba.credibanco.data.provider.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnnulmentResponse(
    @SerializedName("statusCode")
    val statusCode: String =  "",
    @SerializedName("statusDescription")
    val statusDescription: String =  ""
): Parcelable
