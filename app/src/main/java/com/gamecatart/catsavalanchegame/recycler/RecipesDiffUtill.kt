package com.gamecatart.catsavalanchegame.recycler
import androidx.recyclerview.widget.DiffUtil

class RecipesDiffUtill: DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}