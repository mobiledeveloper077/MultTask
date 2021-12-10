package uz.abduvali.domain.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.domain.models.Character

interface CharacterRepository {

    fun getCharacters(page: Int): Flow<Response<Character>>

    fun addCharacterDb(characterEntity: CharacterEntity)
}