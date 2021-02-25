package com.mstar.tv.tvplayer.mvvmcurdapps.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mstar.tv.tvplayer.mvvmcurdapps.repository.SubscriberRepo
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repo: SubscriberRepo): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return SubscriberViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}