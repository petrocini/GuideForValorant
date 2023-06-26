package com.petrocini.guideforvalorant.presentation.agent_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.domain.usecase.GetAgentByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentByIdUseCase: GetAgentByIdUseCase
): ViewModel() {

    private val _agent = MutableLiveData<Agent>()
    val agent: LiveData<Agent> get() = _agent

    fun fetchAgent(id: String) {
        viewModelScope.launch {
            _agent.value = getAgentByIdUseCase.getAgentById(id)
        }
    }

}