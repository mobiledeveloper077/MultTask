package uz.abduvali.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import uz.abduvali.data.database.dao.CharacterDao
import uz.abduvali.data.network.ApiService
import uz.abduvali.domain.entities.CharacterEntity
import uz.abduvali.domain.models.Character
import uz.abduvali.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val characterDao: CharacterDao
) :
    CharacterRepository {

    override fun getCharacters(page: Int): Flow<Response<Character>> {
        return flow { emit(apiService.getCharacters(page)) }
    }

    override fun addCharacterDb(characterEntity: CharacterEntity) {
        characterDao.insert(characterEntity)
    }
}