package com.petrocini.guideforvalorant.presentation.agents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.petrocini.guideforvalorant.databinding.FragmentAgentsBinding
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.presentation.adapter.AgentsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment: Fragment() {

    private lateinit var binding: FragmentAgentsBinding
    private val viewModel: AgentsViewModel by viewModels()

    private lateinit var agentsAdapter: AgentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentsBinding.inflate(inflater, container, false)
        setUpToolbar()
        setUpAgentsAdapter()
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpAgentsAdapter() {
        agentsAdapter = AgentsAdapter(agentClickListener = object : AgentsAdapter.AgentClickListener {
            override fun onAgentClick(agent: Agent) {
                Navigation.findNavController(binding.root).navigate(AgentsFragmentDirections.actionAgentsFragmentToAgentDetailFragment(agent.uuid))
            }
        })
    }

    private fun setUpToolbar() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun setUpRecyclerView() {
        binding.recyclerviewAgents.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewAgents.setHasFixedSize(true)
        binding.recyclerviewAgents.adapter = agentsAdapter
    }

    override fun onStart() {
        super.onStart()
        setUpAgentsObserver()
        setUpLoadingObserver()
    }

    private fun setUpAgentsObserver() {
        viewModel.agents.observe(viewLifecycleOwner) { agents ->
            if (agents != null) {
                agentsAdapter.submitList(agents)
            }
        }
    }

    private fun setUpLoadingObserver() {
        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            if (loading != null) {

            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchAgents()
    }

}