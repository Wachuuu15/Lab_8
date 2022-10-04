package com.example.lab8
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.datasource.model.Result
import com.google.android.material.appbar.MaterialToolbar


class CharactersFragment : Fragment(R.layout.fragment_characters), PersonAdapter.RecyclerPersonClickHandler{

    private lateinit var characters: MutableList<Result>
    private lateinit var adaptere : PersonAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_personList)

        setUpRecycler()
        getCharacters()
    }


    private fun getCharacters(){}

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

