package com.petrocini.guideforvalorant.domain.usecase

import com.petrocini.guideforvalorant.data.dto.toModel
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.domain.repository.AgentRepository
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(
    private val repository: AgentRepository
){
    suspend fun getAgents(): List<Agent> {
        return repository.getAgents().agents.map { agentDto -> agentDto.toModel() }
    }
}