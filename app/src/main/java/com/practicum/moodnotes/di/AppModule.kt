package com.practicum.moodnotes.di

import com.practicum.moodnotes.data.MoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoodRepository(): MoodRepository {
        return MoodRepository()
    }
}