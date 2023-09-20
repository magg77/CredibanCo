package com.prueba.credibanco.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.prueba.credibanco.R
import com.prueba.credibanco.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavigationViewNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        bottomNavigationViewNavView = binding.navView

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_transaction, R.id.navigation_account
            )
        )
        setupActionBarWithNavController(navController)
        */

        bottomNavigationViewNavView.setupWithNavController(navController)
        bottomNavigationViewNavView.setOnApplyWindowInsetsListener(null)
    }

    /*override fun onBackPressed() {

        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.i("back", "1111  hola activity, si ****************")
            }

        })

        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
            super.onBackPressed();   // dispatch event to custom callback, which implemented in fragment
            Log.i("back", "hola activity, si ****************")
        } else {
            // use activity backPressed if there is no callback   added to mOnBackPressedDispatcher
            Log.i("back", "hola activity, nnnnoooooooooooooooooooooooo")
        }
    }*/

}