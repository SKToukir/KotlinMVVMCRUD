package com.mstar.tv.tvplayer.mvvmcurdapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mstar.tv.tvplayer.mvvmcurdapps.databinding.ActivityMainBinding
import com.mstar.tv.tvplayer.mvvmcurdapps.db.SubscriberDAO
import com.mstar.tv.tvplayer.mvvmcurdapps.db.SubscriberDB
import com.mstar.tv.tvplayer.mvvmcurdapps.other.SubscriberAdapter
import com.mstar.tv.tvplayer.mvvmcurdapps.repository.SubscriberRepo
import com.mstar.tv.tvplayer.mvvmcurdapps.ui.SubscriberViewModel
import com.mstar.tv.tvplayer.mvvmcurdapps.ui.SubscriberViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var adapter: SubscriberAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = SubscriberDB.getInstance(this).subscriberDao
        val repo = SubscriberRepo(dao)
        val factory = SubscriberViewModelFactory(repo)
        subscriberViewModel = ViewModelProviders.of(this, factory).get(SubscriberViewModel::class.java)
        binding.subscriberViewModel = subscriberViewModel
        binding.lifecycleOwner = this

        adapter = SubscriberAdapter()

        initRecyclerView()

        displaySubscriberList()
    }

    private fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter
    }

    private fun displaySubscriberList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.d(TAG, "displaySubscriberList: ${it.toString()}")
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }
}