package uz.abduvali.domain.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.domain.models.Character
import uz.abduvali.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private val characterRepository: CharacterRepository) {

    fun getCharacters(page: Int): Flow<Result<Character>> {
        return characterRepository.getCharacters(page)
            .map {
                if (it.isSuccessful) {
                    Result.success(it.body()!!)
                } else {
                    Result.failure(Throwable(it.errorBody().toString()))
                }
            }.catch {
                emit(Result.failure(it))
            }.flowOn(Dispatchers.IO)
    }

    fun addCharacterDb(characterEntity: CharacterEntity) =
        characterRepository.addCharacterDb(characterEntity)
}