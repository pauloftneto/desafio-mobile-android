package br.ftdev.heroisdamarvel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThumbnailResponse(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
) : Parcelable