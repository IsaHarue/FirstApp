package com.isabelle.firstapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.isabelle.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Criar a toolbar
    private lateinit var appBarConfiguration: AppBarConfiguration
    // criar a navegação
    private lateinit var navController: NavController

    //criar o binding
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //configura o binding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configira a navegacao e a toolbar
        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}