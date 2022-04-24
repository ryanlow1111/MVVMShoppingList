package com.example.mvvmshoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglist.data.db.ShoppingDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.data.repositories.ShoppingRepository
import com.example.mvvmshoppinglist.databinding.ActivityShoppingBinding
import com.example.mvvmshoppinglist.other.ShoppingItemAdapter
import com.example.mvvmshoppinglist.ui.shoppinglist.AddDialogListener
import com.example.mvvmshoppinglist.ui.shoppinglist.AddShoppingItemDialog
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import com.example.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModelFactory

@Suppress("DEPRECATION")
class ShoppingActivity : AppCompatActivity() {

    // view binding
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // init database
        val database = ShoppingDatabase(this)

        // init repository
        val repository = ShoppingRepository(database)

        // init view model factory
        val factory = ShoppingViewModelFactory(repository)

        // init view model
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        // init adapter
        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        // init recyclerView
        binding.shoppingList.layoutManager = LinearLayoutManager(this)
        binding.shoppingList.adapter = adapter

        // observe is from LiveData
        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        // floating button
        binding.addButton.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}