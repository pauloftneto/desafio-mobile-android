package br.ftdev.heroisdamarvel.domain.usecase

import br.ftdev.heroisdamarvel.domain.model.Hero
import br.ftdev.heroisdamarvel.domain.repository.HeroServiceRepository
import kotlinx.coroutines.flow.Flow

class HeroUseCase(private val repository: HeroServiceRepository) {

    operator fun invoke(): Flow<List<Hero>> = repository.getHeroes()

}