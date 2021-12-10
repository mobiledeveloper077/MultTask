package uz.abduvali.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update
import uz.abduvali.domain.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Insert
    fun insert(entity: CharacterEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insert(entities: List<CharacterEntity>)

    @Update
    fun update(entity: CharacterEntity)

    @Update
    fun update(entities: List<CharacterEntity>)

    @Delete
    fun delete(entity: CharacterEntity)

    @Delete
    fun delete(entities: List<CharacterEntity>)
}