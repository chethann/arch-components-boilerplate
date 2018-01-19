package com.myntra.go.views.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.myntra.go.R
import com.myntra.go.api.models.search.Product

/**
 * Created by Chethan.n on 18/01/18.
 */
class SearchAdapter(): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private lateinit var mProducts: List<Product>
    private lateinit var onClickListner: View.OnClickListener

    constructor(products: List<Product>, clickListner: View.OnClickListener) : this() {
        mProducts = products
        onClickListner = clickListner
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItem(mProducts.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.product_list_item, parent, false)
        v.setOnClickListener(onClickListner)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mProducts.count()
    }

    public fun setProducts(products: List<Product>) {
        mProducts = products
    }

    class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        fun bindItem(product: Product) {
            val image: ImageView = v.findViewById(R.id.product_image)
            val name: TextView= v.findViewById(R.id.product_name)

            name.setText(product.stylename)
            Glide
                    .with(v.context)
                    .load(product.searchImage)
                    .into(image)
        }
    }
}