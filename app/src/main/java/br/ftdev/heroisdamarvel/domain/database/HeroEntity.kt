package br.ftdev.heroisdamarvel.domain.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.ftdev.heroisdamarvel.domain.model.Thumbnail

@Entity(tableName = "hero_table")
data class HeroEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val description: String,
    val thumbnail: Thumbnail
)