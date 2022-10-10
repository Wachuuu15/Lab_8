package com.example.lab8.fragments
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.Character
import com.example.lab8.R
import com.example.lab8.RickAndMortyDB
import com.example.lab8.adapters.PersonAdapter


class CharactersFragment : Fragment(R.layout.fragment_characters), PersonAdapter.RecyclerPersonClickHandler{

    private lateinit var recyclerView: RecyclerView
    private lateinit var personList: MutableList<Character>
    private lateinit var adaptere : PersonAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_personList)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        personList = RickAndMortyDB.getCharacters()
        adaptere = PersonAdapter(personList, this )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adaptere
    }

    override fun onPersonClicked(persona: Character) {
        val action = CharactersFragmentDirections.actionCharactersFragmentToDetailsFragment(
            persona
        )
        requireView().findNavController().navigate(action)
    }



}

