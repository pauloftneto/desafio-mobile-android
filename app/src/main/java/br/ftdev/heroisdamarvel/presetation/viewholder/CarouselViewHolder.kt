package br.ftdev.heroisdamarvel.presetation.viewholder


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.ftdev.heroisdamarvel.databinding.ListItemBinding
import br.ftdev.heroisdamarvel.domain.model.Hero
import com.bumptech.glide.Glide

class CarouselHolder(
    private val viewBinding: ListItemBinding,
    private val context: Context
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(hero: Hero) = with(viewBinding) {

        Glide.with(context)
            .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
            .centerCrop()
            .into(listItemIcon)
    }
}