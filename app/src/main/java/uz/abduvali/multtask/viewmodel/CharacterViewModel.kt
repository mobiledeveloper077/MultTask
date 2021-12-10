package uz.abduvali.multtask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.domain.interactor.CharacterInteractor
import uz.abduvali.multtask.utils.CharacterResource
import uz.abduvali.multtask.utils.toCharacterEntity
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val characterInteractor: CharacterInteractor) :
    ViewModel() {

    val flow = Pager(PagingConfig(10)) {
        CharacterSource(characterInteractor)
    }.flow.cachedIn(viewModelScope)

//    fun getCharacters(page: Int): StateFlow<CharacterResource> {
//        val stateFlow = MutableStateFlow<CharacterResource>(CharacterResource.Loading)
//
//        viewModelScope.launch {
//            characterInteractor.getCharacters(page)
//                .collect {
//                    if (it.isSuccess) {
//                        val list1 = ArrayList<CharacterEntity>()
//                        it.getOrNull()?.results?.forEach { result ->
//                            val entity = result.toCharacterEntity()
//                            list1.add(entity)
//                            characterInteractor.addCharacterDb(entity)
//                        }
//                        Result.success(list1)
//                        stateFlow.emit(CharacterResource.Success(list1))
//                    } else {
//                        stateFlow.emit(CharacterResource.Error(it.exceptionOrNull()?.message ?: ""))
//                    }
//                }
//        }
//        return stateFlow
//    }
}