package com.example.lab8.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lab8.Character
import com.example.lab8.fragments.CharactersFragment
import com.example.lab8.R

class PersonAdapter(

    private val dataSet: MutableList<Character>,
    private val listener: CharactersFragment
    ) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    interface RecyclerPersonClickHandler{
        fun onPersonClicked(persona: Character)
    }

    class ViewHolder(private val view : View,
                     private val listener: RecyclerPersonClickHandler
    ): RecyclerView.ViewHolder(view){

        private val layoutPerson: ConstraintLayout =  view.findViewById(R.id.item_layoutPersona)
        private val imageView: ImageView = view.findViewById(R.id.image_item_person)
        private val textName: TextView = view.findViewById(R.id.text_name)
        private val textinfo: TextView = view.findViewById(R.id.text_info)
        private val textinfo2: TextView = view.findViewById(R.id.text_info2)



        fun setData(persona: Character){
            textName.text = persona.name
            textinfo.text = persona.species
            textinfo2.text = persona.status
            imageView.load(persona.image)

            layoutPerson.setOnClickListener{
                listener.onPersonClicked(persona)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            . inflate(R.layout.item_recycler_person, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(
            dataSet[position]
        )
    }

    override fun getItemCount()= dataSet.size

}