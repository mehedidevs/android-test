package com.mehedi.beedatesting.repositories

import com.mehedi.beedatesting.data.local.ShopingItem

interface ShoppingRepository {


    suspend fun insertShoppingItem(shoppingItem: ShopingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShopingItem)
}