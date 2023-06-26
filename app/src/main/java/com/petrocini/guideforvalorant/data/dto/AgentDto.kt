package com.petrocini.guideforvalorant.data.dto

import com.petrocini.guideforvalorant.domain.model.Ability
import com.petrocini.guideforvalorant.domain.model.Agent
import com.petrocini.guideforvalorant.domain.model.Media
import com.petrocini.guideforvalorant.domain.model.Role
import com.petrocini.guideforvalorant.domain.model.VoiceLine

data class AgentDto(
    val abilities: List<AbilityDto>,
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
    val role: RoleDto?,
    val uuid: String,
    val voiceLine: VoiceLineDto
)

data class AbilityDto(
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val slot: String
)

fun AbilityDto.toModel() = Ability(
    description,
    displayIcon,
    displayName,
    slot
)

data class MediaDto(
    val id: Int,
    val wave: String,
    val wwise: String
)

fun MediaDto.toModel() = Media(
    id,
    wave,
    wwise
)

data class RoleDto(
    val assetPath: String,
    val description: String,
    val displayIcon: String,
    val displayName: String,
    val uuid: String
)

fun RoleDto.toModel() = Role(
    assetPath,
    description,
    displayIcon,
    displayName,
    uuid
)

data class VoiceLineDto(
    val maxDuration: Double,
    val mediaList: List<MediaDto>,
    val minDuration: Double
)

fun VoiceLineDto.toModel() = VoiceLine(
    maxDuration,
    mediaList.map { mediaDto -> mediaDto.toModel() },
    minDuration
)

fun AgentDto.toModel() = Agent(
    abilities.map { abilityDto -> abilityDto.toModel() },
    assetPath,
    background,
    backgroundGradientColors,
    bustPortrait,
    characterTags,
    description,
    developerName,
    displayIcon,
    displayIconSmall,
    displayName,
    fullPortrait,
    fullPortraitV2,
    isAvailableForTest,
    isBaseContent,
    isFullPortraitRightFacing,
    isPlayableCharacter,
    killfeedPortrait,
    role?.toModel(),
    uuid,
    voiceLine.toModel()
)