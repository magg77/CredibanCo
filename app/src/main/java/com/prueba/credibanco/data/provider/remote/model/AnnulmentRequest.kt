package com.prueba.credibanco.data.provider.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnnulmentRequest(
    @SerializedName("receiptId")
    val receiptId: String =  "",
    @SerializedName("rrn")
    val rrn: String =  ""
): Parcelable
