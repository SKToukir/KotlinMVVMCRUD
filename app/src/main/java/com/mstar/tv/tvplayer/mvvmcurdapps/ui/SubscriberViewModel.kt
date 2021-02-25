package com.mstar.tv.tvplayer.mvvmcurdapps.ui

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mstar.tv.tvplayer.mvvmcurdapps.db.Subscriber
import com.mstar.tv.tvplayer.mvvmcurdapps.repository.SubscriberRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repo: SubscriberRepo) : ViewModel(), Observable {

    companion object{
        private const val TAG = "MainActivity"
    }

    val subscribers = repo.allSubscriber

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveButtonText = MutableLiveData<String>()

    @Bindable
    val deleteButtonText = MutableLiveData<String>()

    init {
        saveButtonText.value = "Save"
        deleteButtonText.value = "Delete All"
    }

    fun saveSubscriber(){
        val name:String = inputName.value!!
        val email:String = inputEmail.value!!
        insertSubscriber(Subscriber(0, name,email))
        inputEmail.value = null
        inputName.value = null
    }

    fun deleteAllSubscriber(){
        Log.d(TAG, "deleteAllSubscriber: ")
        deleteSubscriber()
    }


    private fun insertSubscriber(subscriber: Subscriber) {
        viewModelScope.launch {
            repo.insertSubscriber(subscriber)
        }
    }

    fun updateSubscriber(subscriber: Subscriber) = viewModelScope.launch {
        repo.updateSubscriber(subscriber)
    }

    private fun deleteSubscriber() =
        viewModelScope.launch { repo.deleteAll() }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}