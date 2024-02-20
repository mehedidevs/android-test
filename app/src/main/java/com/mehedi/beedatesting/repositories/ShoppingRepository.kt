package com.mehedi.beedatesting.repositories

import androidx.lifecycle.LiveData
import com.mehedi.beedatesting.data.local.ShopingItem
import com.mehedi.beedatesting.data.remote.responses.ImageResponse
import com.mehedi.beedatesting.utils.Resource
import retrofit2.Response

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShopingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShopingItem)
    fun observeAllShoppingItems(): LiveData<List<ShopingItem>>
    fun observeTotalPrice(): LiveData<Float>
    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}