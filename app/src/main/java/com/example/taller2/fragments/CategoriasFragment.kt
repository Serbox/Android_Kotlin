package com.example.taller2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.taller2.R
import androidx.navigation.fragment.findNavController

class CategoriasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categorias, container, false)

        val btnElectronica = view.findViewById<Button>(R.id.More_button_Electronica)
        val btnRopa = view.findViewById<Button>(R.id.More_button_Ropa)
        val btnHogar = view.findViewById<Button>(R.id.More_button_Hogar)
        val btnDeportes = view.findViewById<Button>(R.id.More_button_Deportes)
        val btnAccesorios = view.findViewById<Button>(R.id.More_button_Accesorios)


        btnElectronica.setOnClickListener {
            findNavController().navigate(R.id.action_CategoriasFragment_to_electronicaFragment)
        }
        btnRopa.setOnClickListener {
            findNavController().navigate(R.id.action_CategoriasFragment_to_ropaFragment)
        }
        btnHogar.setOnClickListener {
            findNavController().navigate(R.id.action_CategoriasFragment_to_hogarFragment)
        }
        btnDeportes.setOnClickListener {
            findNavController().navigate(R.id.action_CategoriasFragment_to_deporteFragment)
        }
        btnAccesorios.setOnClickListener {
            findNavController().navigate(R.id.action_CategoriasFragment_to_accesoriosFragment)
        }

        return view
    }
}
