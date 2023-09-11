package com.example.individual3_m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.individual3_m6.data.Repository
import com.example.individual3_m6.data.Tarea
import com.example.individual3_m6.data.TaskDatabase
import kotlinx.coroutines.launch

class ViewModel(aplication: Application): AndroidViewModel(aplication) {
    private val repository : Repository
    init {
        repository = Repository(TaskDatabase.getDatabase(aplication).getTaskDao())

    }
    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repository.getTareas()
    }

    fun insertarTarea(tarea: Tarea) = viewModelScope.launch{
        repository.insertTask(tarea)
    }
}