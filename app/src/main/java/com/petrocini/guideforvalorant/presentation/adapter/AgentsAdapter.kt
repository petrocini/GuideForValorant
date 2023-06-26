package com.petrocini.guideforvalorant.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.petrocini.guideforvalorant.databinding.ItemAgentBinding
import com.petrocini.guideforvalorant.domain.model.Agent
import com.squareup.picasso.Picasso

class AgentsAdapter(
    private val agentClickListener: AgentClickListener
): ListAdapter<Agent, AgentViewHolder>(AgentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAgentBinding.inflate(inflater, parent, false)
        return AgentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = getItem(position)
        holder.bind(agent, agentClickListener)
    }

    interface AgentClickListener {
        fun onAgentClick(agent: Agent)
    }
}

class AgentViewHolder(private val itemAgentBinding: ItemAgentBinding): RecyclerView.ViewHolder(itemAgentBinding.root) {
    fun bind(agent: Agent, agentClickListener: AgentsAdapter.AgentClickListener) {
        itemAgentBinding.textviewAgentName.text = agent.displayName
        val imageUrl = agent.fullPortrait
        Picasso.get().load(imageUrl).into(itemAgentBinding.imageviewAgentImage)
        itemAgentBinding.root.setOnClickListener {
            agentClickListener.onAgentClick(agent)
        }
    }
}

class AgentDiffCallback: DiffUtil.ItemCallback<Agent>() {

    override fun areItemsTheSame(oldItem: Agent, newItem: Agent): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(oldItem: Agent, newItem: Agent): Boolean {
        return oldItem.equals(newItem)
    }

}