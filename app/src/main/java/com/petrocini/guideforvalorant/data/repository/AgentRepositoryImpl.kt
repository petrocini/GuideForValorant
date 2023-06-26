package com.petrocini.guideforvalorant.data.repository

import com.petrocini.guideforvalorant.data.network.response.GetAgentByIdResponse
import com.petrocini.guideforvalorant.data.network.response.GetAgentsResponse
import com.petrocini.guideforvalorant.data.network.service.ValorantApiService
import com.petrocini.guideforvalorant.domain.repository.AgentRepository
import retrofit2.Response
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private val service: ValorantApiService
): AgentRepository {

    override suspend fun getAgents(): GetAgentsResponse {
        return service.getAgents()
    }

    override suspend fun getAgentById(id: String): GetAgentByIdResponse {
        return service.getAgentsById(id)
    }

}