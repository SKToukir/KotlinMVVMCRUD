package com.mstar.tv.tvplayer.mvvmcurdapps.other

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mstar.tv.tvplayer.mvvmcurdapps.R
import com.mstar.tv.tvplayer.mvvmcurdapps.db.Subscriber
import kotlinx.android.synthetic.main.item_view.view.*

class SubscriberAdapter(): RecyclerView.Adapter<SubscriberAdapter.SubscriberModel>() {

    private val subscriberList = ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return SubscriberModel(view)
    }

    override fun onBindViewHolder(holder: SubscriberModel, position: Int) {

        holder.itemView.textView.text = subscriberList[position].name
        holder.itemView.textView2.text = subscriberList[position].email

    }

    override fun getItemCount(): Int {
        return subscriberList.size
    }

    fun setList(list: List<Subscriber>){
        subscriberList.clear()
        subscriberList.addAll(list)
    }

    inner class SubscriberModel(itemView: View) : RecyclerView.ViewHolder(itemView)
}