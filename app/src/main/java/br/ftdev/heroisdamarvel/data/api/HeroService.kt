package br.ftdev.heroisdamarvel.data.api

import br.ftdev.heroisdamarvel.BuildConfig
import br.ftdev.heroisdamarvel.data.model.HeroResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroService {

    @GET("characters")
    suspend fun getHeroes(
        @Query("ts") ts: String = "1634590800",
        @Query("offset") offset: Int? = null,
        @Query("apikey") apikey: String = BuildConfig.API_KEY,
        @Query("hash") hash: String = BuildConfig.API_KEY_MD5
    ): HeroResponse

}