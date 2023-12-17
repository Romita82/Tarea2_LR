package com.example.tarea2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea2.adapter.CursosOnlineAdapter
import com.example.tarea2.databinding.ActivityMainEjercicio2Binding

//Ejercicio 2: Lista de webs con RecyclerView

class MainActivityEjercicio2 : AppCompatActivity() {
    //creamos una variable binding
    private lateinit var binding: ActivityMainEjercicio2Binding
    private lateinit var adapter: CursosOnlineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflamos la vista del Activity
        binding = ActivityMainEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root) //root, vista principal que contiene las demás vistas

        initRecyclerView()
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)

        binding.recyclerCursosAndKot.layoutManager = manager
        binding.recyclerCursosAndKot.adapter = adapter

        binding.recyclerCursosAndKot.addItemDecoration(decoration)


    }

}