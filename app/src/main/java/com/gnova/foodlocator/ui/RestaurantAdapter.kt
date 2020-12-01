package com.gnova.foodlocator.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gnova.foodlocator.Const.BASE_IMAGE_URL
import com.gnova.foodlocator.R
import com.gnova.foodlocator.api.models.Restaurant
import com.gnova.foodlocator.refactorImgUrl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.restaurant_grid_view_item.view.*

class RestaurantAdapter() : ListAdapter<Restaurant, RestaurantAdapter.RestaurantHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_grid_view_item, parent, false)
        return RestaurantHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        val restaurants = getItem(position)
        holder.bind(restaurants)
    }

    class RestaurantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(restaurant: Restaurant) {

            itemView.name.text = restaurant.name
            itemView.cuisine.text = restaurant.cuisines[0].name
            itemView.rating.text = restaurant.ratingStars.toString()

            Picasso.get()
                .load(refactorImgUrl(BASE_IMAGE_URL, restaurant.id))
                //.load(restaurant.LogoUrl)
                .into(itemView.logoImage)



        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Restaurant>() {

        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

}