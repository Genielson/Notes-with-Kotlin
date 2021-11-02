package com.example.projectnotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class),version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNotesDao():NoteDao

    // Padrao Singleton
    companion object {

        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getDatabase(context: Context):NoteDatabase{

            if(INSTANCE == null){

                INSTANCE = Room.databaseBuilder(context.applicationContext,
                NoteDatabase::class.java,
                    "note_database"
                    ).build()

            }

            return INSTANCE as NoteDatabase

        }

    }

}