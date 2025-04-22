package com.example.taller2.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.taller2.R

class HistorialFragment : Fragment() {

    private lateinit var tvHistorial: TextView

    private fun mostrarHistorial(prefs: SharedPreferences) {
        val historial = """
            Nombre: ${prefs.getString("nombre", "No disponible")}
            Edad: ${prefs.getInt("edad", 0)}
            Correo: ${prefs.getString("correo", "No disponible")}
            Programa: ${prefs.getString("programa", "No disponible")}
            Semestre: ${prefs.getInt("semestre", 0)}
        """.trimIndent()

        tvHistorial.text = historial
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_historial, container, false)

        tvHistorial = view.findViewById(R.id.tvHistorial)


        val prefs = requireContext().getSharedPreferences("datos_usuario", Context.MODE_PRIVATE)


        mostrarHistorial(prefs)

        return view
    }
}
