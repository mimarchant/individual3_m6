package com.example.individual3_m6.data

import androidx.lifecycle.LiveData

class Repository(private val tareaDao: Dao) {
    suspend fun insertTask(tarea: Tarea){
        tareaDao.insertarTareas(tarea) //Insertar tarea

    }

    fun getTareas(): LiveData<List<Tarea>> {
        return tareaDao.getTareas() //obtener tarea
    }
}