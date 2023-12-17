package com.example.tarea2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2.databinding.ActivityMainEjercicio1Binding
//Ejercicio 1: Conversor de moneda

class MainActivityEjercicio1 : AppCompatActivity(), View.OnClickListener {
    val RATIO = 0.9

    lateinit private var binding: ActivityMainEjercicio1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainEjercicio1Binding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //botón convertir en activity_main.xml
        //binding.btConvertir.setOnClickListener(this)
        binding.rbDolarEuro.setOnClickListener(this)
        binding.rbEuroDolar.setOnClickListener(this)
    }
    override fun onClick(view: View) {

        if((binding.rbEuroDolar.isChecked) || (binding.rbDolarEuro.isChecked)) {
            try {
                if(binding.rbEuroDolar.isChecked) {
                    //con trim se eliminan los posibles espacios en blanco que ingrese el usuario
                    val euroText = binding.etEuros.text.toString().trim()
                    //se controla que el campo no este vacio antes de hacer la conversion
                    if (euroText.isNotEmpty()) {
                        val euros = euroText.toDouble()
                        binding.etCambio.setText(
                            Conversion.convertirADolares(
                                String.format("%.2f", euros), RATIO

                            )
                        )
                    }else{
                    Toast.makeText(this, "Ingrese una cantidad en euros", Toast.LENGTH_SHORT)
                        .show()
                    }
                }
                if (binding.rbDolarEuro.isChecked) {
                    val dolarText = binding.etDolares.text.toString().trim()
                    if (dolarText.isNotEmpty()) {
                        val dolares = dolarText.toDouble()
                        binding.etCambio.setText(
                            Conversion.convertirAEuros(
                                String.format("%.2f", dolares), RATIO

                            )
                        )
                    }else{
                        Toast.makeText(this, "Ingrese una cantidad en dolares", Toast.LENGTH_SHORT)
                            .show()
                        }
                }
                } catch (e: NumberFormatException) {
                Toast.makeText(this, "Error en la conversion. Debe ingresar numeros validos " + e.message, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}