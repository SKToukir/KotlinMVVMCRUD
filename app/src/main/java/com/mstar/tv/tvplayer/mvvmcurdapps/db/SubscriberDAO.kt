package com.mstar.tv.tvplayer.mvvmcurdapps.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber): Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber) : Int

    @Query("DELETE FROM subscriber_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM subscriber_table")
    fun getAllData(): LiveData<List<Subscriber>>
}