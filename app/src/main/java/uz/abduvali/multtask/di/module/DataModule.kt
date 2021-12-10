package uz.abduvali.multtask.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.abduvali.data.network.ApiService
import uz.abduvali.data.repository.CharacterRepositoryImpl
import uz.abduvali.domain.repository.CharacterRepository
import javax.inject.Singleton

@Module(includes = [DataModule.BindModule::class])
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Module
    abstract class BindModule {

        @Binds
        abstract fun bindApiRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository
    }
}