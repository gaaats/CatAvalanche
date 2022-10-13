package com.gamecarart.carace.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gamecarart.carace.R
import com.gamecarart.carace.databinding.VievpagerHolderBinding

class VievPagerAdapter (val list: List<Int>): RecyclerView.Adapter<VievPagerAdapter.VievPagerHolder>() {

    inner class VievPagerHolder (view: View): RecyclerView.ViewHolder(view){

        val binding = VievpagerHolderBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VievPagerHolder {
        val viev = LayoutInflater.from(parent.context).inflate(R.layout.vievpager_holder, parent, false)
        return VievPagerHolder(viev)
    }

    override fun onBindViewHolder(holder: VievPagerHolder, position: Int) {
        holder.binding.imageViev.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}