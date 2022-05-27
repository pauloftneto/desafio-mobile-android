package br.ftdev.heroisdamarvel.data.local

import br.ftdev.heroisdamarvel.domain.database.HeroEntity

interface HeroLocalDataSource {
    fun getAll(): List<HeroEntity>
    fun updateHero(heroList: List<HeroEntity>)
}