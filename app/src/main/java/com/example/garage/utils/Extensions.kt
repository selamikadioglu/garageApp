package com.example.garage.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0L

fun Any?.isNull() = this == null

fun <T> LifecycleOwner.collectFlow(flow: Flow<T>, collector: FlowCollector<T>) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect(collector)
        }
    }
}

fun <T> LifecycleOwner.collect(sharedFlow: SharedFlow<T>, observer: (T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        sharedFlow.collect { t -> observer(t) }
    }
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun <T> LifecycleOwner.observe(liveData: SingleLiveEvent<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(view) }
}

fun Context.hideKeyboard(view: View?) {
    view?.let {
        val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(it.windowToken, 0)
    }

}

fun <T> LifecycleOwner.liveDataObserver(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this) { it?.let { t -> action(t) } }
}