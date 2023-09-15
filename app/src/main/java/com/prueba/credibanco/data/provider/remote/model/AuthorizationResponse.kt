package com.prueba.credibanco.data.provider.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthorizationResponse(
    @SerializedName("receiptId")
    val receiptId: String = "",
    @SerializedName("rrn")
    val rrn: String = "",
    @SerializedName("statusCode")
    val statusCode: String = "",
    @SerializedName("statusDescription")
    val statusDescription: String = ""
) : Parcelable

fun AuthorizationResponse_to_mutableList(authorizationResponse: AuthorizationResponse): MutableList<AuthorizationResponse> {
    return mutableListOf<AuthorizationResponse>(
        AuthorizationResponse(
            authorizationResponse.receiptId,
            authorizationResponse.rrn,
            authorizationResponse.statusCode,
            authorizationResponse.statusDescription
        )
    )
}

data class AuthorizationResponseList(
    val authorizationResponseList: List<AuthorizationResponse>
)
