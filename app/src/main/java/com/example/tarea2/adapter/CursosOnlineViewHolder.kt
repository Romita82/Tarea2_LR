package com.example.tarea2.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.CursosOnline
import com.example.tarea2.databinding.ItemCursosonlineBinding
import com.google.android.material.snackbar.Snackbar

class CursosOnlineViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //creamos la variable binding y accedemos a las vistas
    val binding = ItemCursosonlineBinding.bind(view)

    fun render(cursosOnlineModel: CursosOnline) {
        //accedemos a las vistas y le asignamos valor
        binding.tvNombreWeb.text = cursosOnlineModel.nombreWeb
        binding.tvLinkWeb.text = cursosOnlineModel.link



        //al hacer click en el link, se muestra la descripción y el contacto
        binding.tvLinkWeb.setOnClickListener{
            val msj = "Descripción: ${cursosOnlineModel.descripcion}\n Contacto: ${cursosOnlineModel.contacto}"
            val snackbar = Snackbar.make(binding.root, msj, Snackbar.LENGTH_LONG)
            snackbar.show()
        }

    }

}
