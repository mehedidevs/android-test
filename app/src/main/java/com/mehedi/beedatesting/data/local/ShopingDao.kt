package com.mehedi.beedatesting.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShopingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShopingItem)

    @Update
    suspend fun updateShoppingItem(shoppingItem: ShopingItem)


    @Query("SELECT * FROM ShopingItem")
    fun observeShoppingItem(): LiveData<List<ShopingItem>>

    @Query("SELECT SUM(price*amount)  FROM ShopingItem")
    fun observeTotalPrice(): LiveData<Float>
}