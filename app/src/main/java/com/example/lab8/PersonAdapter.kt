package com.example.lab8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class PersonAdapter(
    private val dataSet: MutableList<Character>
    ) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    class ViewHolder(private val view : View): RecyclerView.ViewHolder(view){
        private val imageType: ImageView = view.findViewById(R.id.image_item_person)
        private val textName: TextView = view.findViewById(R.id.text_name)
        private val textinfo: TextView = view.findViewById(R.id.text_info)
        private val textinfo2: TextView = view.findViewById(R.id.text_info2)

        fun setData(persona:Character){
            textName.text = persona.name
            textinfo.text = persona.species
            textinfo2.text= persona.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            . inflate(R.layout.item_recycler_person, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(
            dataSet[position]
        )

    }

    override fun getItemCount()= dataSet.size

}