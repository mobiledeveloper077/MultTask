package uz.abduvali.multtask.utils

import uz.abduvali.domain.entities.CharacterEntity

sealed class CharacterResource {

    object Loading : CharacterResource()
    data class Error(val message: String) : CharacterResource()
    data class Success(val list: List<CharacterEntity>?) : CharacterResource()
}