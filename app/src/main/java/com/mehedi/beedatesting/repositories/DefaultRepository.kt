package com.mehedi.beedatesting.repositories

import androidx.lifecycle.LiveData
import com.mehedi.beedatesting.data.local.ShopingItem
import com.mehedi.beedatesting.data.local.ShoppingDao
import com.mehedi.beedatesting.data.remote.PixabayApi
import com.mehedi.beedatesting.data.remote.responses.ImageResponse
import com.mehedi.beedatesting.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayApi: PixabayApi
) : ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShopingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)

    }

    override suspend fun deleteShoppingItem(shoppingItem: ShopingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)

    }

    override fun observeAllShoppingItems(): LiveData<List<ShopingItem>> {
        return shoppingDao.observeShoppingItem()

    }

    override fun observeTotalPrice(): LiveData<Float> {

        return shoppingDao.observeTotalPrice()

    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {


        return try {

            val response = pixabayApi.searchForImages(imageQuery)

            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("No data found", null)

            } else {
                Resource.error("Something went wrong ..!", null)
            }

        } catch (e: Exception) {
            Resource.error("${e.message}", null)
        }
    }


}