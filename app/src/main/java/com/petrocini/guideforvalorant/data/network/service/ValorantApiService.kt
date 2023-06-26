package com.petrocini.guideforvalorant.data.network.service

import com.petrocini.guideforvalorant.data.network.response.GetAgentByIdResponse
import com.petrocini.guideforvalorant.data.network.response.GetAgentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ValorantApiService {

    @GET("agents")
    suspend fun getAgents(
        @Query("language") language: String = "en-US",
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ): GetAgentsResponse

    @GET("agents/{uuid}")
    suspend fun getAgentsById(
        @Path("uuid") uuid: String,
        @Query("language") language: String = "en-US",
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ): GetAgentByIdResponse

    companion object {
        const val API_BASE_URL = "https://valorant-api.com/v1/"
    }

}