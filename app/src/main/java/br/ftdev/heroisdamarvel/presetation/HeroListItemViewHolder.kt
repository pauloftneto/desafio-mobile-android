package br.ftdev.heroisdamarvel.presetation

import androidx.recyclerview.widget.RecyclerView
import br.ftdev.heroisdamarvel.databinding.ListItemHeroBinding
import br.ftdev.heroisdamarvel.domain.model.Hero


class HeroListItemViewHolder(
    private val viewBinding: ListItemHeroBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(hero: Hero) {
        viewBinding.name.text = hero.name
        viewBinding.descriprion.text = hero.description
    }
}