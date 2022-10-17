package com.gamecarartmoster.monsterfall.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NevsApiModule {

    /// it is faaaaake
    @Provides
    @Singleton
    fun providesNevsAPIService(): RecipeService {
        val retrofit = Retrofit.Builder()
            .baseUrl("frgtyh")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RecipeService::class.java)
    }

    fun fakeFun(){
        providesNevsAPIService()
    }
}