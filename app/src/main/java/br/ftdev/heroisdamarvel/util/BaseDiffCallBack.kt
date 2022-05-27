package br.ftdev.heroisdamarvel.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

@SuppressLint("DiffUtilEquals")
class BaseDiffCallBack<A : Any> : DiffUtil.ItemCallback<A>() {
    override fun areItemsTheSame(oldItem: A, newItem: A) = oldItem.toString() == newItem.toString()

    override fun areContentsTheSame(oldItem: A, newItem: A) = oldItem == newItem
}
