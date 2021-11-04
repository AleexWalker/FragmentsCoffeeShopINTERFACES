package com.example.fragmentscoffeeshop

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cards.*
import kotlinx.android.synthetic.main.item_cards_fragment2.*
import java.util.*
import kotlin.collections.ArrayList

class CardAdapterFragment2(var items: ArrayList<TarjetaCardFragment2>) : RecyclerView.Adapter<CardAdapterFragment2.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textoOpinion : TextView

        init {
            textoOpinion = itemView.findViewById(R.id.textView4)
        }

        fun bindTarjeta(t: TarjetaCardFragment2, onClick: (View) -> Unit) = with(itemView) {
            textoOpinion.text = t.opinion
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards_fragment2, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val itemCard = items.get(pos)
        viewHolder.bindTarjeta(itemCard, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}