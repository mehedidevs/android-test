package com.mehedi.beedatesting.di

import android.content.Context
import androidx.room.Room
import com.mehedi.beedatesting.data.local.ShoppingDao
import com.mehedi.beedatesting.data.local.ShoppingItemDB
import com.mehedi.beedatesting.data.remote.PixabayApi
import com.mehedi.beedatesting.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesShoppingItemDB(
        @ApplicationContext context: Context
    ): ShoppingItemDB {
        return Room.databaseBuilder(
            context,
            ShoppingItemDB::class.java,
            Constants.DATABSE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesShoppingDao(db: ShoppingItemDB): ShoppingDao {
        return db.shoppingDao()
    }


    @Provides
    @Singleton
    fun providesRetrofit(): PixabayApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PixabayApi::class.java)

    }


}