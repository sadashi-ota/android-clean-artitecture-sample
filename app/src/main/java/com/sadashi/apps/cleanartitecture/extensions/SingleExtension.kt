package com.sadashi.apps.cleanartitecture.extensions

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

fun <T> Single<T>.observeOnMainThread() = observeOn(AndroidSchedulers.mainThread())