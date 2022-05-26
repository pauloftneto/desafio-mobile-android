package br.ftdev.heroisdamarvel.domain.mappers

import br.ftdev.heroisdamarvel.data.model.ResultResponse
import br.ftdev.heroisdamarvel.data.model.ThumbnailResponse
import br.ftdev.heroisdamarvel.domain.database.HeroEntity
import br.ftdev.heroisdamarvel.domain.model.Hero
import br.ftdev.heroisdamarvel.domain.model.Thumbnail

fun List<ResultResponse>.toHeroEntity(): List<HeroEntity> {
    return map {
        HeroEntity(
            id = it.id,
            name = it.name,
            description = it.description,
            thumbnail = it.thumbnail.toThumbnailEntity()
        )
    }
}

fun ThumbnailResponse.toThumbnailEntity(): Thumbnail {
    return Thumbnail(
        path = path,
        extension = extension
    )

}

fun List<HeroEntity>.toHero(): List<Hero> {
    return map {
        Hero(
            id = it.id,
            name = it.name,
            description = it.description,
            thumbnail = it.thumbnail
        )
    }
}
