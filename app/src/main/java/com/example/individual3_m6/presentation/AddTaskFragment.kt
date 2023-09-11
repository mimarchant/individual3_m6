package com.example.individual3_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.individual3_m6.R
import com.example.individual3_m6.data.Tarea
import com.example.individual3_m6.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {
    lateinit var binding: FragmentAddTaskBinding
    private val tareaVM: ViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(layoutInflater,container,false)
        initListener()
        cargarTareas()
        return binding.root
    }
    private fun initListener() {
        binding.btnAgregar.setOnClickListener {
            val texto = binding.editText.text.toString()
            guardarTexto(texto)
            binding.editText.setText("")
            Toast.makeText(requireContext(), "Se ha agregado un texto", Toast.LENGTH_SHORT).show()
        }
    }
    private fun guardarTexto(text: String) {
        val tarea = Tarea(text, " ")
        tareaVM.insertarTarea(tarea)
    }
    private fun cargarTareas(){
        tareaVM.obtenerTareas().observe(viewLifecycleOwner){
            val tareaAText = it.joinToString("\n") { it.nombre }
            binding.textView.text = tareaAText
        }
    }

}