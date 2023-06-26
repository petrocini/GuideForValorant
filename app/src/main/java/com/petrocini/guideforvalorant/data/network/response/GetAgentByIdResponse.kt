package com.petrocini.guideforvalorant.data.network.response

import com.google.gson.annotations.SerializedName
import com.petrocini.guideforvalorant.data.dto.AgentDto

data class GetAgentByIdResponse(
    val status: Int,
    @SerializedName("data")
    val agent: AgentDto
)