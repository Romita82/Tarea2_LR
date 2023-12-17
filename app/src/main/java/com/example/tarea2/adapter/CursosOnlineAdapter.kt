package com.example.tarea2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.CursosOnline
import com.example.tarea2.R

class CursosOnlineAdapter(private val cursosOnlineList:List<CursosOnline>,
                          private val clickListener: ItemClickListener): RecyclerView.Adapter<CursosOnlineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosOnlineViewHolder {
    //va a devolver el item al ViewHolder por cada objeto que haya en CursosOnline
        val layoutInflater = LayoutInflater.from(parent.context)
        return CursosOnlineViewHolder(layoutInflater.inflate(R.layout.item_cursosonline,parent,false))

    }
    //para que se cargue el tamaño total de la lista
    override fun getItemCount(): Int {
        return cursosOnlineList.size
    }

    override fun onBindViewHolder(holder: CursosOnlineViewHolder, position: Int) {
        //pasa por cada uno de los items y va a llamar a la funcion render cursosOnlineModel
        val item = cursosOnlineList[position]
        holder.binding.ivWeb.setImageResource(item.photo)
        holder.render(item)

        holder.itemView.setOnClickListener{
            clickListener.onItemClick(cursosOnlineList.get(position))
        }
    }


    interface ItemClickListener{
        fun onItemClick(cursosOnline: CursosOnline)

    }
    /*fun remove(position: Int) {
        cursosOnlineList.removeAt(position)
        notifyDataSetChanged()
    }*/
}

