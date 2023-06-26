package com.petrocini.guideforvalorant.domain.model

import com.petrocini.guideforvalorant.presentation.adapter.AgentsAdapter
import java.io.Serializable

data class Agent(
    val abilities: List<Ability>,
    val assetPath: String,
    val background: String?,
    val backgroundGradientColors: List<String>,
    val bustPortrait: String?,
    val characterTags: List<String>?,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String?,
    val fullPortraitV2: String?,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val killfeedPortrait: String,
    val role: Role?,
    val uuid: String,
    val voiceLine: VoiceLine
): Serializable {
    override fun equals(other: Any?): Boolean {
        val comparisonAgent = other as Agent
        return comparisonAgent.uuid == this.uuid
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

data class Ability(
    val description: String,
    val displayIcon: String?,
    val displayName: String,
    val slot: String
)

data class Media(
    val id: Int,
    val wave: String,
    val wwise: String
)

data class Role(
    val assetPath: String,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val uuid: String
)

data class VoiceLine(
    val maxDuration: Double,
    val mediaList: List<Media>,
    val minDuration: Double
)