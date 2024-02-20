package com.mehedi.beedatesting.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.beedatesting.data.local.ShopingItem
import com.mehedi.beedatesting.data.remote.responses.ImageResponse
import com.mehedi.beedatesting.repositories.ShoppingRepository
import com.mehedi.beedatesting.utils.Event
import com.mehedi.beedatesting.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(private val repository: ShoppingRepository) :
    ViewModel() {


    val shoppingItems = repository.observeAllShoppingItems()
    val totalPrice = repository.observeTotalPrice()

    private val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val images: LiveData<Event<Resource<ImageResponse>>> get() = _images

    private val _curlImages = MutableLiveData<String>()
    val curlImages: LiveData<String> get() = _curlImages


    private val _insertShoppingItemStatus = MutableLiveData<Event<Resource<ShopingItem>>>()
    val insertShoppingItemStatus: LiveData<Event<Resource<ShopingItem>>> get() = _insertShoppingItemStatus


    fun setCurrentImageUrl(url: String) {

        _curlImages.postValue(url)

    }



    fun deleteShoppingItem(shoppingItem: ShopingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertShoppingItemIntoDb(shoppingItem: ShopingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun insertShoppingItem(name: String, amountString: String, priceString: String) {

    }

    fun searchForImage(imageQuery: String) {

    }


}