package com.mstar.tv.tvplayer.mvvmcurdapps.repository

import com.mstar.tv.tvplayer.mvvmcurdapps.db.Subscriber
import com.mstar.tv.tvplayer.mvvmcurdapps.db.SubscriberDAO

class SubscriberRepo(private val subscriberDao: SubscriberDAO) {

    suspend fun insertSubscriber(subscriber: Subscriber): Long {
        return subscriberDao.insertSubscriber(subscriber)
    }

    suspend fun updateSubscriber(subscriber: Subscriber): Int {
        return subscriberDao.updateSubscriber(subscriber)
    }

    suspend fun deleteSubscriber(subscriber: Subscriber): Int {
       return subscriberDao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(): Int = subscriberDao.deleteAll()

    val allSubscriber = subscriberDao.getAllData()

}