package io.github.zoha131.ecommerce.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel: ViewModel(){
    protected val _statusLiveData = MutableLiveData<Async>()
    val statusLiveData: LiveData<Async> get() = Transformations.map(_statusLiveData){it}

    protected val disposable = CompositeDisposable()

    init {
        _statusLiveData.value = Loading
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}

