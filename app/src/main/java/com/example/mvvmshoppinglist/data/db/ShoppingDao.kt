package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem

// Everything need to be annotation to use room
@Dao
interface ShoppingDao {

    // insert or replace item by checking the id of the item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    // delete item from database
    @Delete
    suspend fun delete(item: ShoppingItem)

    // get all shopping item with sql query
    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}