package br.ftdev.heroisdamarvel.domain.repository

import br.ftdev.heroisdamarvel.data.remote.HeroRemoteDataSource
import br.ftdev.heroisdamarvel.domain.model.Hero
import kotlinx.coroutines.flow.Flow


class HeroServiceRepositoryImpl(
    private val heroRemoteDataSource: HeroRemoteDataSource,
) : HeroServiceRepository {

    override fun getHeroes(): Flow<List<Hero>> {
        return heroRemoteDataSource.getHeroes()
    }

}
