package com.example.fragmentscoffeeshop

import android.widget.Button
import android.widget.RatingBar
import androidx.appcompat.view.menu.MenuView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cards.*

import java.util.*
import kotlin.collections.ArrayList

class CardAdapter(var items: ArrayList<TarjetaCard>) : RecyclerView.Adapter<CardAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imagenPortada : ImageView
        var textoNombre : TextView
        var ratingBar : RatingBar
        var textoPuntuacion : TextView
        var textLocalizacion : TextView
        var boton : Button

        init {

            imagenPortada = itemView.findViewById(R.id.imageView)
            textoNombre = itemView.findViewById(R.id.textView)
            textoPuntuacion = itemView.findViewById(R.id.textView2)
            textLocalizacion = itemView.findViewById(R.id.textView3)
            ratingBar = itemView.findViewById(R.id.ratingBar)
            boton = itemView.findViewById(R.id.button)

        }

        fun bindTarjeta(t: TarjetaCard, onClick: (View) -> Unit) = with(itemView) {
            imagenPortada.setImageResource(t.imagenPortada)
            textoNombre.text = resources.getString(t.textoNombre)
            textLocalizacion.text = resources.getString(t.textoLocalizacion)

            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val itemCard = items.get(pos)
        viewHolder.bindTarjeta(itemCard, onClick)

        viewHolder.ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            viewHolder.textoPuntuacion.text = ratingBar.rating.toInt().toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}