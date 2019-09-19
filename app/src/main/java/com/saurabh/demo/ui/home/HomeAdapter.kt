package com.saurabh.demo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.saurabh.demo.R
import com.saurabh.demo.data.network.entities.Product
import kotlinx.android.synthetic.main.item_product.view.*

class HomeAdapter(
    private val onProductClickListener: OnProductClickListener
) : ListAdapter<Product, HomeAdapter.ViewHolder>(ProductDiffCallback()) {

    interface OnProductClickListener {
        fun onProductClick(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
        holder.itemView.setOnClickListener {
            onProductClickListener.onProductClick(product)
        }
    }

    class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            itemView.ivItemProduct.load(product.image)
            itemView.tvItemProductName.text = product.productName
            itemView.tvItemProductCompany.text = product.company
            itemView.tvItemProductPrice.text = "₹ ${product.price}"
        }
    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}