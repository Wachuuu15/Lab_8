package com.example.lab8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class TopAppBarActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_app_bar)

        //configurar
        val navHostFragment = supportFragmentManager.findFragmentById(
        R.id.fragmentContainer_basicToolbarActivity
    )as NavHostFragment
        navController = navHostFragment.navController

        val appbarConfig = AppBarConfiguration(navController.graph)
        toolbar = findViewById(R.id.toolbar_topAppbarActivity)
        toolbar.setupWithNavController(navController, appbarConfig)
        listenToNavGraphChanges()
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