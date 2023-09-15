package com.prueba.credibanco.data.provider.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthorizationRequest(
    @SerializedName("id")
    val id: String =  "",
    @SerializedName("commerceCode")
    val commerceCode: String = "",
    @SerializedName("terminalCode")
    val terminalCode: String = "",
    @SerializedName("amount")
    val amount: String = "",
    @SerializedName("card")
    val card: String = ""
): Parcelable
