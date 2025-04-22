package com.example.taller2.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.taller2.R

class PerfilFragment : Fragment() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etPrograma: EditText
    private lateinit var etSemestre: EditText
    private lateinit var tvDatosGuardados: TextView
    private lateinit var btnGuardar: Button

    private fun mostrarDatosGuardados(prefs: SharedPreferences) {
        val datos = """
        Nombre: ${prefs.getString("nombre", "")}
        Edad: ${prefs.getInt("edad", 0)}
        Correo: ${prefs.getString("correo", "")}
        Programa: ${prefs.getString("programa", "")}
        Semestre: ${prefs.getInt("semestre", 0)}
    """.trimIndent()

        tvDatosGuardados.text = datos
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Cambié aquí el layout para que sea fragment_perfil en vez de activity_profile
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        // Asociamos las vistas con el código
        etNombre = view.findViewById(R.id.etNombre)
        etEdad = view.findViewById(R.id.etEdad)
        etCorreo = view.findViewById(R.id.etCorreo)
        etPrograma = view.findViewById(R.id.etPrograma)
        etSemestre = view.findViewById(R.id.etSemestre)
        btnGuardar = view.findViewById(R.id.btnGuardar)
        tvDatosGuardados = view.findViewById(R.id.tvDatosGuardados)

        // Obtenemos las preferencias de SharedPreferences
        val prefs = requireContext().getSharedPreferences("datos_usuario", Context.MODE_PRIVATE)

        // Mostramos los datos guardados si los hay
        mostrarDatosGuardados(prefs)

        // Cuando se presiona el botón Guardar
        btnGuardar.setOnClickListener {
            val editor = prefs.edit()
            // Guardamos los datos en SharedPreferences
            editor.putString("nombre", etNombre.text.toString())
            editor.putInt("edad", etEdad.text.toString().toIntOrNull() ?: 0)
            editor.putString("correo", etCorreo.text.toString())
            editor.putString("programa", etPrograma.text.toString())
            editor.putInt("semestre", etSemestre.text.toString().toIntOrNull() ?: 0)
            editor.apply()

            // Mostramos un mensaje de que los datos se guardaron
            Toast.makeText(requireContext(), "Datos guardados", Toast.LENGTH_SHORT).show()

            // Actualizamos los datos guardados en pantalla
            mostrarDatosGuardados(prefs)
        }

        return view
    }
}
