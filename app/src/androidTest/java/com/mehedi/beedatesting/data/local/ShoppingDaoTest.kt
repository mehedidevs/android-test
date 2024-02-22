package com.mehedi.beedatesting.data.local


import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.mehedi.beedatesting.getOrAwaitValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@RunWith(AndroidJUnit4::class)
@SmallTest
@HiltAndroidTest
class ShoppingDaoTest {

    @get:Rule
    val intstanceTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    //  lateinit var database: ShoppingItemDB
    @Inject
    @Named("test_dao")
    lateinit var shoppingDao: ShoppingDao
    lateinit var appContext: Context

    @Before
    fun setUp() {

        appContext = InstrumentationRegistry.getInstrumentation().targetContext

    }


    @Test
    fun insertShoppingItemTest() {

        runTest {
            val shoppingItem = ShopingItem("Camera", 110, 75.0f, "img.png", 1)
            shoppingDao.insertShoppingItem(shoppingItem)

            val items = shoppingDao.observeShoppingItem().getOrAwaitValue()
            assertThat(items).contains(shoppingItem)

        }
    }

    @Test
    fun deleteShoppingItemTest() {

        runTest {

            val shoppingItem = ShopingItem("Camera", 110, 75.0f, "img.png")

            shoppingDao.insertShoppingItem(shoppingItem)
            shoppingDao.deleteShoppingItem(shoppingItem)

            val items = shoppingDao.observeShoppingItem().getOrAwaitValue()
            assertThat(items).doesNotContain(shoppingItem)
        }
    }

    @Test
    fun observePriceShoppingItemTest() {

        runTest {

            val shoppingItem1 = ShopingItem("Camera", 3, 75.0f, "img.png")
            val shoppingItem2 = ShopingItem("Camera", 9, 85.0f, "img.png")
            val shoppingItem3 = ShopingItem("Camera", 8, 95.0f, "img.png")

            shoppingDao.insertShoppingItem(shoppingItem1)
            shoppingDao.insertShoppingItem(shoppingItem2)
            shoppingDao.insertShoppingItem(shoppingItem3)


            val itemPrice = shoppingDao.observeTotalPrice().getOrAwaitValue()
            assertThat(itemPrice).isEqualTo((3 * 75) + (9 * 85) + (8 * 95))
        }
    }


    @After
    fun tearDown() {


    }


}