package br.ftdev.heroisdamarvel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroResponse(
    @SerializedName("data")
    val data: DataResponse
) : Parcelable