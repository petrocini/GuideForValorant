package com.petrocini.guideforvalorant.domain.repository

import com.petrocini.guideforvalorant.data.network.response.GetAgentByIdResponse
import com.petrocini.guideforvalorant.data.network.response.GetAgentsResponse
import retrofit2.Response

interface AgentRepository {
    suspend fun getAgents(): GetAgentsResponse
    suspend fun getAgentById(id: String): GetAgentByIdResponse
}