package com.mehedi.beedatesting.di

import android.content.Context
import androidx.room.Room
import com.mehedi.beedatesting.data.local.ShoppingDao
import com.mehedi.beedatesting.data.local.ShoppingItemDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestAppModule {


    @Provides
    @Singleton
    @Named("test_dao")
    fun providesInMemoryDb(
        @ApplicationContext context: Context
    ): ShoppingDao {
        val database =
            Room.inMemoryDatabaseBuilder(
                context,
                ShoppingItemDB::class.java
            ).allowMainThreadQueries()
                .build()

        return database.shoppingDao()
    }


}