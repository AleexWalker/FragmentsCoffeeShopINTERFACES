package com.example.fragmentscoffeeshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentscoffeeshop.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                val recView: RecyclerView = view.findViewById<RecyclerView>(R.id.rec1)
                val itemsFotos = ArrayList<TarjetaCard>()
                itemsFotos.add(TarjetaCard(R.drawable.images , R.string.anticocaffe , R.string.rome))
                itemsFotos.add(TarjetaCard(R.drawable.images1 , R.string.cofeeroom , R.string.berlin))
                itemsFotos.add(TarjetaCard(R.drawable.images2 , R.string.ibiza, R.string.madrid))
                itemsFotos.add(TarjetaCard(R.drawable.images3 , R.string.pudding , R.string.barcelona))
                itemsFotos.add(TarjetaCard(R.drawable.images4 , R.string.express , R.string.london))
                itemsFotos.add(TarjetaCard(R.drawable.images5 , R.string.corner , R.string.valencia))
                itemsFotos.add(TarjetaCard(R.drawable.images6 , R.string.sweet, R.string.amsterdam))

                val adaptador = CardAdapter(itemsFotos)

                recView.adapter = adaptador
                recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

                adaptador.onClick = {
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}