package br.ftdev.heroisdamarvel.presetation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import br.ftdev.heroisdamarvel.databinding.ListItemHeroBinding
import br.ftdev.heroisdamarvel.domain.model.Hero

class HeroListAdapter : ListAdapter<Hero, HeroListItemViewHolder>(HeroDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListItemViewHolder {
        val viewBinding =
            ListItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HeroListItemViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: HeroListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class HeroDiffCallBack : DiffUtil.ItemCallback<Hero>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean =
        oldItem == newItem
}