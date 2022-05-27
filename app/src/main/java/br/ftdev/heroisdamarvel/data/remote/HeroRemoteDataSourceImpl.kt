package br.ftdev.heroisdamarvel.data.remote

import br.ftdev.heroisdamarvel.data.api.HeroService
import br.ftdev.heroisdamarvel.data.local.HeroLocalDataSource
import br.ftdev.heroisdamarvel.data.utils.Operation
import br.ftdev.heroisdamarvel.domain.mappers.toHero
import br.ftdev.heroisdamarvel.domain.mappers.toHeroEntity
import br.ftdev.heroisdamarvel.domain.mappers.toThumbnailEntity
import br.ftdev.heroisdamarvel.domain.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HeroRemoteDataSourceImpl(
    private val heroService: HeroService,
    private val localDataSource: HeroLocalDataSource
) : HeroRemoteDataSource {

    override fun getHeroes(): Flow<List<Hero>> {
        return flow {
            emit(localDataSource.getAll().toHero())

            val response = try {
                Operation.Success(heroService.getHeroes())
            } catch (throwable: Throwable) {
                Operation.Error(throwable)
            }

            when (response) {
                is Operation.Success -> {
                    val heroEntity = response.dataType.data.results.toHeroEntity()
                    localDataSource.updateHero(heroEntity)
                    emit(heroEntity.toHero())
                }
                is Operation.Error -> {
                    throw response.throwable
                }
            }
        }
    }

}