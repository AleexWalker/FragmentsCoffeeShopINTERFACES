package com.example.fragmentscoffeeshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentscoffeeshop.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recView2: RecyclerView = view.findViewById<RecyclerView>(R.id.rec2)

        val itemOpiniones = ArrayList<TarjetaCardFragment2>()
        itemOpiniones.add(TarjetaCardFragment2("Muy recomedable.\nVolvere seguro."))
        itemOpiniones.add(TarjetaCardFragment2("Acogedor. Muy buen ambiente."))
        itemOpiniones.add(TarjetaCardFragment2("Buenos precios."))
        itemOpiniones.add(TarjetaCardFragment2("Servicio algo flojo."))
        itemOpiniones.add(TarjetaCardFragment2("Para repetir...extensa carta de cafes."))


        val adaptador = CardAdapterFragment2(itemOpiniones)

        recView2.adapter = adaptador
        adaptador.onClick = {}
        recView2.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}