package com.example.tarea2

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2.adapter.CursosOnlineAdapter

//Ejercicio 3: app con dos fragments

class MainWebsFragment : Fragment(), CursosOnlineAdapter.ItemClickListener {

    private lateinit var adapterNombres: CursosOnlineAdapter
    private var list : ArrayList<CursosOnline> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        //se infla el layout para el fragment
        val view = inflater.inflate(R.layout.fragment_main_webs, container, false)

        buildDisplayData()
        initRecyclerView(view)
        return view
    }

    private fun buildDisplayData() {
        list.add(CursosOnline("AristiDevs",
                                "https://cursokotlin.com/",
                                R.drawable.aristidevs,
                                "Curso gratuito de Kotlin.",
                                "https://bit.ly/3bmeQvm"))

        list.add(CursosOnline("Developers",
                                "https://developer.android.com/kotlin",
                                R.drawable.developers,
                                "Android para desarrolladores",
                                "GooglePlay"))
        list.add(CursosOnline("Mouredev",
                                "https://mouredev.com/",
                                R.drawable.mouredev,
                                "Curso de Android desde cero.",
                                "braismoure@mouredev.com"))
        list.add(CursosOnline("Jetbrains",
                                "https://www.jetbrains.com/es-es/" +
                                        "pages/academy/kotlin/",
                                R.drawable.jetbrains,
                                "Cree aplicaciones reales desde cero.",
                                "https://twitter.com/JetBrains_Edu"))
        list.add(CursosOnline("Envatotuts+",
                                "https://code.tutsplus.com/es",
                                R.drawable.evantotuts,
                                "Aprende habilidades creativas.",
                                " https://evanto.com/contact"))
        list.add(CursosOnline("Udemy",
                                "https://www.udemy.com/course/" +
                                        "programacion-de-aplicaciones-android-kotlin",
                                R.drawable.udemy,
                                "La tienda virtual de aprendizaje y enseñanza global líder.",
                                "Support@udemy.com"))

    }

    private fun initRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerCursosAndKot)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        adapterNombres = CursosOnlineAdapter(list,this)
        recyclerView.adapter = adapterNombres

        //right swipe on recyclerview
        val itemSwipe = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
                ): Boolean{
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showDialog(viewHolder)
            }
        }
        val swap = ItemTouchHelper(itemSwipe)
        swap.attachToRecyclerView(recyclerView)

    }
    private fun showDialog(viewHolder: RecyclerView.ViewHolder){
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Borrar Item")
        builder.setMessage("Esta seguro de borrar el item?")
        builder.setPositiveButton("Aceptar"){dialog, which ->
            val position = viewHolder.adapterPosition

            //adapterNombres.remove(position)
        }
        builder.setNegativeButton("Cancelar"){dialog,wich ->
            val position = viewHolder.adapterPosition
            adapterNombres.notifyItemChanged(position)
        }
        builder.show()
    }


    companion object {

        @JvmStatic
        fun newInstance(): MainWebsFragment{
            return MainWebsFragment()
                }
            }
    override fun onItemClick(cursosOnline: CursosOnline) {
        val fragment: Fragment = DetailFragment.newInstance(cursosOnline.nombreWeb!!)
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.hide(activity?.supportFragmentManager!!.findFragmentByTag("fragment_main_webs")!!)
        transaction.add(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}


