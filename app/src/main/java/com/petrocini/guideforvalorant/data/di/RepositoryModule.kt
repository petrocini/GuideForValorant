package com.petrocini.guideforvalorant.data.di

import com.petrocini.guideforvalorant.data.network.service.ValorantApiService
import com.petrocini.guideforvalorant.data.repository.AgentRepositoryImpl
import com.petrocini.guideforvalorant.domain.repository.AgentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAgentRepository(
        valorantApiService: ValorantApiService
    ): AgentRepository {
        return AgentRepositoryImpl(valorantApiService)
    }

}