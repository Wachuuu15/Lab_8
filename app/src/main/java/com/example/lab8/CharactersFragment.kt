package com.example.lab8
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.appbar.MaterialToolbar

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var personList: MutableList<Character>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_personList)
        setUpRecycler()

    }


    private fun setUpRecycler() {
        personList = RickAndMortyDB.getCharacters()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = PersonAdapter(personList)

    }
}