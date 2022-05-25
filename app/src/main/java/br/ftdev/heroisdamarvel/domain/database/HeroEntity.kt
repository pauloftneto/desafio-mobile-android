package br.ftdev.heroisdamarvel.domain.database

import androidx.room.*
import br.ftdev.heroisdamarvel.data.model.HeroResponse
import br.ftdev.heroisdamarvel.data.model.ResultResponse
import br.ftdev.heroisdamarvel.data.model.ThumbnailResponse
import br.ftdev.heroisdamarvel.domain.model.Hero
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hero")
data class HeroEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String
)

@Dao
interface HeroDao {

    @Insert
    suspend fun add(hero: List<HeroEntity>)

    @Query("SELECT * FROM hero")
    suspend fun getAll(): List<HeroEntity>

    @Query("DELETE from hero")
    suspend fun deleteAll()

    @Transaction
    suspend fun update(hero: List<HeroEntity>) {
        deleteAll()
        add(hero)
    }

}

fun List<ResultResponse>.toEntity(): List<HeroEntity> {
    return map {
        HeroEntity(
            id = it.id,
            name = it.name,
            description = it.description
        )
    }
}

fun List<HeroEntity>.toHero(): List<Hero> {
    return map {
        Hero(
            id = it.id,
            name = it.name,
            description = it.description
        )
    }
}