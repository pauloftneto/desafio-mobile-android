package br.ftdev.heroisdamarvel.domain.repository

import br.ftdev.heroisdamarvel.data.model.HeroResponse
import br.ftdev.heroisdamarvel.data.model.ResultResponse
import br.ftdev.heroisdamarvel.data.utils.Operation
import br.ftdev.heroisdamarvel.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface HeroServiceRepository {

    suspend fun getHeroes(): Flow<Operation.Success<HeroResponse>>

}