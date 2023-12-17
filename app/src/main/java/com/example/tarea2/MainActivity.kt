package com.example.tarea2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tarea2.databinding.ActivityMainBinding

//Actividad principal con botones para lanzar cada actividad (ejercicio)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.btnActividad1.setOnClickListener {
            val intent = Intent(this, MainActivityEjercicio1::class.java)
            startActivity(intent)
        }
        binding.btnActividad2.setOnClickListener{
            val intent = Intent(this, MainActivityEjercicio2::class.java )
            startActivity(intent)
        }
        binding.btnActividad3.setOnClickListener{
            val fragment: Fragment = MainWebsFragment.newInstance()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_container, fragment, "fragment_main_webs")
            transaction.commit()

        }
    }
}