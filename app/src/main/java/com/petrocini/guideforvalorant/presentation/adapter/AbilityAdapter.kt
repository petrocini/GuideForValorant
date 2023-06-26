package com.petrocini.guideforvalorant.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.petrocini.guideforvalorant.databinding.ItemAbilityBinding
import com.petrocini.guideforvalorant.domain.model.Ability
import com.squareup.picasso.Picasso

class AbilityAdapter(): ListAdapter<Ability, AbilityViewHolder>(AbilityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAbilityBinding.inflate(inflater, parent, false)
        return AbilityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        val ability = getItem(position)
        holder.bind(ability)
    }

}

class AbilityViewHolder(private val itemAbilityBinding: ItemAbilityBinding): RecyclerView.ViewHolder(itemAbilityBinding.root) {
    fun bind(ability: Ability) {
        itemAbilityBinding.textviewAbilityName.text = ability.displayName
        Picasso.get().load(ability.displayIcon).into(itemAbilityBinding.imageviewAbilityIcon)
        itemAbilityBinding.texviewAbilityDescription.text = ability.description
    }
}

class AbilityDiffCallback: DiffUtil.ItemCallback<Ability>() {

    override fun areItemsTheSame(oldItem: Ability, newItem: Ability): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(oldItem: Ability, newItem: Ability): Boolean {
        return oldItem.equals(newItem)
    }

}