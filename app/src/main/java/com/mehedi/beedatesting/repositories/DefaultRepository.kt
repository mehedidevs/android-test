package com.mehedi.beedatesting.repositories

import com.mehedi.beedatesting.data.local.ShoppingDao
import com.mehedi.beedatesting.data.remote.PixabayApi
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayApi: PixabayApi
) {
}