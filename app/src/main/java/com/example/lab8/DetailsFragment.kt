package com.example.lab8

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load


class DetailsFragment : Fragment(R.layout.fragment_details) {

    val args: DetailsFragmentArgs by navArgs()
    private lateinit var textname: TextView
    private lateinit var textspecie: TextView
    private lateinit var textstatus: TextView
    private lateinit var textgender: TextView
    private lateinit var imageViewpersona: ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textname =view.findViewById(R.id.textViewname)
        textspecie = view.findViewById(R.id.textView5)
        textstatus = view.findViewById(R.id.textView6)
        textgender = view.findViewById(R.id.textView7)
        imageViewpersona = view.findViewById(R.id.imageViewpersona)

            textname.text = args.persona.name
            textspecie.text = args.persona.species
            textstatus.text = args.persona.status
            textgender.text = args.persona.gender
            imageViewpersona.load(args.persona.image)


    }



}