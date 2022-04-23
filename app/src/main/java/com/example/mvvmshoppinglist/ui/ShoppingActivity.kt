package com.example.mvvmshoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModelFactory

@Suppress("DEPRECATION")
class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        // init database
        val database = ShoppingDatabase(this)

        // init repository
        val repository = ShoppingRepository(database)

        // init view model factory
        val factory = ShoppingViewModelFactory(repository)

        // init view model
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}