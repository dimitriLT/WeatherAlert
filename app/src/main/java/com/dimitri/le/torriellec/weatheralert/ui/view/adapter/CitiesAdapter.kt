package com.dimitri.le.torriellec.weatheralert.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dimitri.le.torriellec.weatheralert.R
import kotlinx.android.synthetic.main.layout_city.view.*

class CitiesAdapter(private val listener: ((String) -> Unit)?) :
    ListAdapter<String, CitiesAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_city, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val city = getItem(position)
        holder.city.text = city
        holder.itemView.setOnClickListener {
            listener?.invoke(city)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val city: TextView = view.textview_city
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}