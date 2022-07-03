package com.example.moviestestproject

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.moviestestproject.di.AppComponent
import com.example.moviestestproject.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(context = applicationContext)
    }

    companion object {
        const val TAG = "MoviesApp"
    }
}

fun Fragment.getAppComponent() = (requireActivity().application as App).appComponent