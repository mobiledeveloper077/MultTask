package uz.abduvali.multtask.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.abduvali.data.database.AppDatabase
import uz.abduvali.data.database.dao.CharacterDao
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao = appDatabase.characterDao()
}