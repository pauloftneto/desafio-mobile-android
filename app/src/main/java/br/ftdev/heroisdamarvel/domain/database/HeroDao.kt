package br.ftdev.heroisdamarvel.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface HeroDao {

    @Insert
    fun addHero(hero_table: List<HeroEntity>)

    @Query("SELECT * FROM hero_table")
    fun getAll(): List<HeroEntity>

    @Query("DELETE from hero_table")
    fun deleteAll()

    @Transaction
    fun updateHero(heroList: List<HeroEntity>) {
        deleteAll()
        addHero(heroList)
    }

}