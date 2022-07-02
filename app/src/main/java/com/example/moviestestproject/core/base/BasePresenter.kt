package com.example.moviestestproject.core.base

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import moxy.MvpView
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<V : MvpView> : MvpPresenter<V>() {

    private val parentJob = SupervisorJob()
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, t ->
        Log.e(TAG, t.message.toString())
    }
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    protected val coroutineScope = CoroutineScope(coroutineContext)

    override fun detachView(view: V) {
        super.detachView(view)
        parentJob.cancel()
    }

    companion object {
        private const val TAG = "Coroutine Ex Handler"
    }
}