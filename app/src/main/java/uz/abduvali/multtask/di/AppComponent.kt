package uz.abduvali.multtask.di

import dagger.BindsInstance
import dagger.Component
import uz.abduvali.multtask.App
import uz.abduvali.multtask.di.module.AppModule
import uz.abduvali.multtask.di.module.DataModule
import uz.abduvali.multtask.di.module.ViewModelModule
import uz.abduvali.multtask.presentation.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: App
        ): AppComponent
    }

    fun inject(homeFragment: HomeFragment)
}