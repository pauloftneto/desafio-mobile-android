package br.ftdev.heroisdamarvel.presetation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.ftdev.heroisdamarvel.databinding.ListItemBinding
import br.ftdev.heroisdamarvel.domain.model.Hero
import br.ftdev.heroisdamarvel.presetation.viewholder.CarouselHolder
import br.ftdev.heroisdamarvel.util.BaseDiffCallBack

class ItemAdapter : ListAdapter<Hero, CarouselHolder>(BaseDiffCallBack<Hero>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselHolder {
        val context = parent.context
        val viewBinding =
            ListItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return CarouselHolder(viewBinding, context)
    }

    override fun onBindViewHolder(holder: CarouselHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
