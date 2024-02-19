package com.mehedi.beedatesting.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

)
