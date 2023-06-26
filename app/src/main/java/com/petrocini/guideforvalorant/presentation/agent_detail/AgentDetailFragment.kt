package com.petrocini.guideforvalorant.presentation.agent_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.petrocini.guideforvalorant.databinding.FragmentAgentDetailBinding
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.presentation.adapter.AbilityAdapter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailFragment: Fragment() {

    private lateinit var binding: FragmentAgentDetailBinding
    private val viewModel: AgentDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val agentId = AgentDetailFragmentArgs.fromBundle(requireArguments()).agentId
        viewModel.fetchAgent(agentId)
    }

    override fun onStart() {
        super.onStart()
        setUpAgentObserver()
    }

    private fun setUpAgentObserver() {
        viewModel.agent.observe(viewLifecycleOwner) { agent ->
            if (agent != null) {
                setAgentDetails(agent)
            }
        }
    }

    private fun setAgentDetails(agent: Agent) {
        Picasso.get().load(agent.fullPortrait).into(binding.imageviewAgentImage)
        Picasso.get().load(agent.role?.displayIcon).into(binding.imageviewAgentTypeIcon)
        binding.texviewAgentType.text = agent.role?.displayName
        binding.tvAgentDetailDesc.text = agent.description

        val abilityAdapter = AbilityAdapter()
        abilityAdapter.submitList(agent.abilities)
        binding.recyclerviewAgentsAbilities.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewAgentsAbilities.setHasFixedSize(true)
        binding.recyclerviewAgentsAbilities.adapter = abilityAdapter
    }

}