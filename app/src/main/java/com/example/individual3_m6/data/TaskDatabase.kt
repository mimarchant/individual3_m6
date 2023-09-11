package com.example.individual3_m6.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarea:: class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "tarea_baseDato"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}