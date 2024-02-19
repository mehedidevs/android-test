package com.mehedi.beedatesting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShopingItem::class], version = 1
)
abstract class ShoppingItemDB  : RoomDatabase(){
    abstract fun shoppingDao(): ShoppingDao
}