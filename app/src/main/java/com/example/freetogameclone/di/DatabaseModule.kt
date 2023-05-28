package com.example.freetogameclone.di

import android.content.Context
import androidx.room.Room
import com.example.freetogameclone.data.local.GamesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGamesDatabase(
        @ApplicationContext context: Context
    ): GamesDatabase{
        return Room.databaseBuilder(
            context,
            GamesDatabase::class.java,
            name = "games_database"
        ).build()
    }
}