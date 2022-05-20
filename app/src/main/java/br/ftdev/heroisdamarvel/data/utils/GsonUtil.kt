package br.ftdev.heroisdamarvel.data.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonUtil {

    val gson: Gson by lazy { GsonBuilder().create() }

}