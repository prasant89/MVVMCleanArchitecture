package com.prasant.binapani.di

import com.prasant.binapani.data.remote.FakeApiService
import com.prasant.binapani.data.repository.UserRepositoryImpl
import com.prasant.binapani.domain.repository.UserRepository
import com.prasant.binapani.domain.usecase.GetUsersUseCase
import com.prasant.binapani.domain.usecase.ValidateEmailUseCase
import com.prasant.binapani.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://fakeapi.com/" // Fake URL

    @Provides
    @Singleton
    fun provideUserRepository(apiService: FakeApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }

    @Provides
    fun provideValidateEmailUseCase(userRepository: UserRepository): ValidateEmailUseCase {
        return ValidateEmailUseCase(userRepository)
    }

    @Provides
    fun provideValidatePasswordUseCase(userRepository: UserRepository): ValidatePasswordUseCase {
        return ValidatePasswordUseCase(userRepository)
    }


    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideFakeApiService(retrofit: Retrofit): FakeApiService {
        return retrofit.create(FakeApiService::class.java)
    }

}