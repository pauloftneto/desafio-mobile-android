package br.ftdev.heroisdamarvel.domain.repository

import br.ftdev.heroisdamarvel.data.api.HeroService
import br.ftdev.heroisdamarvel.data.utils.Operation
import br.ftdev.heroisdamarvel.domain.database.HeroDao
import br.ftdev.heroisdamarvel.domain.database.toEntity
import br.ftdev.heroisdamarvel.domain.database.toHero

import kotlinx.coroutines.flow.flow

class HeroServiceRepositoryImpl(
    private val heroService: HeroService,
    private val heroDao: HeroDao
) : HeroServiceRepository {

    override suspend fun getHeroes() = flow {
        emit(heroDao.getAll().toHero())

        val response = try {
            Operation.Success(heroService.getHeroes())
        } catch (throwable: Throwable) {
            Operation.Error(throwable)
        }

        when (response) {
            is Operation.Success -> {
                val heroEntity = response.dataType.data.results.toEntity()
                heroDao.update(heroEntity)
                emit(heroEntity.toHero())
            }
            is Operation.Error -> {
                throw response.throwable
            }
        }
    }

}
