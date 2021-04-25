package com.axell.marvelcharacters.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(@ApplicationContext appContext: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .build()
    }
}
