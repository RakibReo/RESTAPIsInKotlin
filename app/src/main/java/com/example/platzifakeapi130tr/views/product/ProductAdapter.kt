package com.example.platzifakeapi130tr.views.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.platzifakeapi130tr.databinding.ItemProductBinding
import com.example.platzifakeapi130tr.models.product.ResponseProductItem

//ss-36

class ProductAdapter() :  ListAdapter<ResponseProductItem, ProductAdapter.ProductViewHolder>(COMPARATOR) {

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<ResponseProductItem>() {
            override fun areItemsTheSame(
                oldItem: ResponseProductItem, newItem: ResponseProductItem
            ): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseProductItem, newItem: ResponseProductItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false),

            )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position).let {
            holder.binding.titleTextView.text = it.title
            holder.binding.descriptionTextView.text = it.description
            holder.binding.priceTextView.text = "Price : $${it.price}"

            it.images?.get(0)?.let { img_url ->
                holder.binding.image1.load(img_url)
            }

            it.images?.get(1)?.let { img_url ->
                holder.binding.image2.load(img_url)
            }

            it.images?.get(2)?.let { img_url ->
                holder.binding.image3.load(img_url)

            }





            it.category?.let { ctg ->
                holder.binding.categoryNameTextView.text = ctg.name
                holder.binding.categoryImageView.load(ctg.image)

            }

//            holder.itemView.setOnClickListener { _ ->
//
//                listener.productClick(it.id)
//
//
//            }


        }
    }

}