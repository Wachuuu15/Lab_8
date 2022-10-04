package com.example.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import okhttp3.internal.notify

class MainActivity : AppCompatActivity(){
    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController
    private lateinit var personList: MutableList<Character>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //configurar
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainer_basicToolbarActivity
        )as NavHostFragment
        navController = navHostFragment.navController

        val appbarConfig = AppBarConfiguration(navController.graph)
        toolbar = findViewById(R.id.toolbar_topAppbarActivity)
        toolbar.setupWithNavController(navController, appbarConfig)
        setUpRecycler()
        listenToNavGraphChanges()
        setListeners()
    }

    private fun setListeners() {
        toolbar.setOnMenuItemClickListener{
            //dependiendo de la opcion
            when(it.itemId){
              R.id.menu_item_sync->{
                  personList.sortBy {Character -> Character.name}

              }
                R.id.menu_item_ordenar->{
                    personList.sortByDescending { Character -> Character.name }
                }
            }
            true
        }
    }

    private fun setUpRecycler() {
        personList = RickAndMortyDB.getCharacters()
    }

    private fun listenToNavGraphChanges(){
        navController.addOnDestinationChangedListener{_,destination,_ ->
            when (destination.id){
                R.id.detailsFragment ->{
                    toolbar.menu.findItem(R.id.menu_item_sync).isVisible=false
                    toolbar.menu.findItem(R.id.menu_item_ordenar).isVisible=false
                }

                else ->{
                    toolbar.visibility= View.VISIBLE
                }
            }
        }
    }
}