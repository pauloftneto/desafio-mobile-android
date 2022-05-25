package br.ftdev.heroisdamarvel.domain.repository

import br.ftdev.heroisdamarvel.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface HeroServiceRepository {

    suspend fun getHeroes(): Flow<List<Hero>>

}