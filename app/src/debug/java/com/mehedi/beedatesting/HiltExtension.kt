package com.mehedi.beedatesting

import android.app.Activity
import android.app.Application
import android.content.ComponentName
import android.content.Intent
import android.gesture.Prediction
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.EmptyFragmentActivity
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.testing.manifest.R.style.FragmentScenarioEmptyFragmentActivityTheme
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import dagger.internal.Preconditions
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
inline fun <reified T : Fragment> launchFragmentInHiltContainer(
    fragmentAgrs: Bundle? = null,
    themeResId: Int = FragmentScenarioEmptyFragmentActivityTheme,
    fragmentFactory: FragmentFactory? = null,
    crossinline action: T.() -> Unit = {}
) {

    val mainActivityIntent = Intent.makeMainActivity(
        ComponentName(
            ApplicationProvider.getApplicationContext(),
            HiltTestActivity::class.java
        )
    ).putExtra(EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId)

    ActivityScenario.launch<HiltTestActivity>(mainActivityIntent).onActivity { activity ->

        fragmentFactory?.let {

            activity.supportFragmentManager.fragmentFactory = it
        }

        val fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
            Preconditions.checkNotNull(T::class.java.classLoader),
            T::class.java.name
        )

        fragment.arguments = fragmentAgrs

        activity.supportFragmentManager.beginTransaction().add(android.R.id.content, fragment, "")
            .commitNow()

        (fragment as T).action()

    }


}

