package br.ftdev.heroisdamarvel.presetation


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.ftdev.heroisdamarvel.databinding.ListItemHeroBinding
import br.ftdev.heroisdamarvel.domain.model.Hero
import com.bumptech.glide.Glide


class HeroListItemViewHolder(
    private val viewBinding: ListItemHeroBinding,
    private val context: Context
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(hero: Hero) = with(viewBinding) {
        name.text = hero.name
        descriprion.text = hero.description

        Glide.with(context)
            .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
            .into(picture)
    }
}