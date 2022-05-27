package br.ftdev.heroisdamarvel.data.remote

import br.ftdev.heroisdamarvel.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface HeroRemoteDataSource {

    fun getHeroes(): Flow<List<Hero>>

}