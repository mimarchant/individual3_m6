package com.example.individual3_m6.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_tarea")
data class Tarea(val nombre: String, val fecha:String){
    @PrimaryKey(autoGenerate = true) var id : Long = 0
}