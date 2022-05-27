package br.ftdev.heroisdamarvel.data.local

import br.ftdev.heroisdamarvel.domain.database.HeroDao
import br.ftdev.heroisdamarvel.domain.database.HeroEntity

class HeroLocalDataSourceImpl(private val heroDao: HeroDao) : HeroLocalDataSource {

    override fun getAll(): List<HeroEntity> = heroDao.getAll()

    override fun updateHero(heroList: List<HeroEntity>) =
        heroDao.updateHero(heroList)
}