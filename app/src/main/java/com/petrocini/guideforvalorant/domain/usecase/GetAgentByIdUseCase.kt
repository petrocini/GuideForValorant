package com.petrocini.guideforvalorant.domain.usecase

import com.petrocini.guideforvalorant.data.dto.toModel
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.domain.repository.AgentRepository
import javax.inject.Inject

class GetAgentByIdUseCase @Inject constructor(
    private val repository: AgentRepository
){
    suspend fun getAgentById(id: String): Agent {
        return repository.getAgentById(id).agent.toModel()
    }
}