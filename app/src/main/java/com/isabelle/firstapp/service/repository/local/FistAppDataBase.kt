package com.isabelle.firstapp.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.isabelle.firstapp.service.model.Pessoa

//Colocar as entidades do projeto
@Database(entities = [Pessoa::class], version = 1)
abstract class FirstAppDataBase : RoomDatabase() {

    // DAOs
    abstract fun pessoaDAO(): PessoaDAO

    companion object {
        @Volatile
        private lateinit var INSTANCE: FirstAppDataBase

        fun getDataBase(context: Context): FirstAppDataBase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        FirstAppDataBase::class.java,
                        "firstapp_database" //Nome do banco de dados
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}