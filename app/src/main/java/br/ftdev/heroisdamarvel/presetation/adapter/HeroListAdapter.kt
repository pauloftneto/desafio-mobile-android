package br.ftdev.heroisdamarvel.presetation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.ftdev.heroisdamarvel.databinding.ListItemHeroBinding
import br.ftdev.heroisdamarvel.domain.model.Hero
import br.ftdev.heroisdamarvel.presetation.viewholder.HeroListItemViewHolder
import br.ftdev.heroisdamarvel.util.BaseDiffCallBack

class HeroListAdapter : ListAdapter<Hero, HeroListItemViewHolder>(BaseDiffCallBack<Hero>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListItemViewHolder {
        val context = parent.context
        val viewBinding =
            ListItemHeroBinding.inflate(LayoutInflater.from(context), parent, false)

        return HeroListItemViewHolder(viewBinding, context)
    }

    override fun onBindViewHolder(holder: HeroListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

