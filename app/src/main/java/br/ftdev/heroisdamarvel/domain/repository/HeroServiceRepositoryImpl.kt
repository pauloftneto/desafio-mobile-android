package br.ftdev.heroisdamarvel.domain.repository

import br.ftdev.heroisdamarvel.data.api.HeroService
import br.ftdev.heroisdamarvel.data.utils.Operation
import br.ftdev.heroisdamarvel.domain.database.HeroDao

import kotlinx.coroutines.flow.flow

class HeroServiceRepositoryImpl(
    private val heroService: HeroService,
) : HeroServiceRepository {

    override suspend fun getHeroes() = flow {

        val response = try {
            Operation.Success(heroService.getHeroes())
        } catch (throwable: Throwable) {
            Operation.Error(throwable)
        }

        when (response) {
            is Operation.Success -> {
                emit(response)
            }
            is Operation.Error -> {
               throw response.throwable
            }
        }
    }

}
