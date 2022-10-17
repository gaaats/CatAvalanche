package com.gamecarartsnov.furioussnovman.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gamecarartsnov.furioussnovman.R
import com.gamecarartsnov.furioussnovman.databinding.SinglePersonBinding
import kotlin.random.Random


class PersonListAdapter() :
    ListAdapter<Person, PersonListAdapter.PersonsVievHolder>(RecipesDiffUtill()) {

    private var onItemClickListener: ((person: Person) -> Unit)? = null
    private var addToFavorite: ((recipe: Person) -> Unit)? = null

    class PersonsVievHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = SinglePersonBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsVievHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.single_person, parent, false).also {
                return PersonsVievHolder(it)
            }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PersonsVievHolder, position: Int) {
        val currentItem = getItem(position)
        val listNames = listOf(
            "sasha",
            "masha",
            "roma",
            "denis",
            "eva",
            "nastya",
            "kolya",
            "john",
            "noname",
            "rembo",
            "frodo",
            "gimli"
        )

        val listImages = listOf(
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10,
        )
        holder.binding.apply {
            val currentImg = listImages.random()
            val currentScore = Random.nextInt(1, 5000)
            tvName.text = currentItem.name
            tvScore.text = currentScore.toString()
            imgPersonAvataer.setImageResource(currentImg)
            root.setOnClickListener {
                onItemClickListener?.invoke(currentItem)
            }

        }
    }

    fun setOnItemClickListener(listener: (person: Person) -> Unit) {
        onItemClickListener = listener
    }
//
//    fun setOnItemClickListenerHeart(listener: (holidayName: RecipesListNetItem) -> Unit) {
//        addToFavorite = listener
//    }
}