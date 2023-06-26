package com.petrocini.guideforvalorant.presentation.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.domain.usecase.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
): ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    private val _agents = MutableLiveData<List<Agent>>()
    val agents: LiveData<List<Agent>> get() = _agents

    fun fetchAgents() {
        viewModelScope.launch {
            _loading.value = true
            _agents.value = getAgentsUseCase.getAgents()
            _loading.value = false
        }
    }
}