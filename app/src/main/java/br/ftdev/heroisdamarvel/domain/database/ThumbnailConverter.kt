package br.ftdev.heroisdamarvel.domain.database

import androidx.room.TypeConverter
import br.ftdev.heroisdamarvel.domain.model.Thumbnail
import com.google.gson.Gson

class ThumbnailConverter {

    @TypeConverter
    fun stringToThumbnail(value: String): Thumbnail = Gson().fromJson(value, Thumbnail::class.java)

    @TypeConverter
    fun thumbnailToString(thumbnail: Thumbnail): String = Gson().toJson(thumbnail)

}
