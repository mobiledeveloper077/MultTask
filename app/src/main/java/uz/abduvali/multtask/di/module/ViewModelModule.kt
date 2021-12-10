package uz.abduvali.multtask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.abduvali.multtask.viewmodel.CharacterViewModel
import uz.abduvali.multtask.viewmodel.DaggerViewModelFactory
import uz.abduvali.multtask.viewmodel.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun bindsCharacterViewModel(viewModel: CharacterViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(factoryDagger: DaggerViewModelFactory): ViewModelProvider.Factory

}