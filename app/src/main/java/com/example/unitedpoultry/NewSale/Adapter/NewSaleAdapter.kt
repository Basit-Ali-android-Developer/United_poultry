package com.example.unitedpoultry.NewSale.Adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unitedpoultry.adminproduct.model.Product
import com.example.unitedpoultry.databinding.ItemProductBinding

class NewSaleAdapter(
    private val products: List<Product>,
    private val quantityMap: MutableMap<Int, Int>
) : RecyclerView.Adapter<NewSaleAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var textWatcher: TextWatcher? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.binding.tvProductName.text = product.name

        // Remove previous watcher before setting text during recycling
        holder.textWatcher?.let { holder.binding.etQuantity.removeTextChangedListener(it) }

        holder.binding.etQuantity.setText(
            quantityMap[product.id]?.toString() ?: ""
        )

        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val enteredQty = s.toString().toIntOrNull() ?: 0
                var allowedQty = enteredQty

                if (product.name.contains("Tray", ignoreCase = true)) {
                    // Trays cannot exceed 11
                    allowedQty = enteredQty.coerceAtMost(11).coerceAtLeast(0)
                }

                // If entered value exceeded allowed limit (e.g. > 11 trays), fix text field safely
                if (allowedQty != enteredQty) {
                    holder.binding.etQuantity.removeTextChangedListener(this)
                    holder.binding.etQuantity.setText(if (allowedQty > 0) allowedQty.toString() else "")
                    holder.binding.etQuantity.setSelection(holder.binding.etQuantity.text?.length ?: 0)
                    holder.binding.etQuantity.addTextChangedListener(this)
                }

                if (allowedQty > 0) {
                    quantityMap[product.id] = allowedQty
                } else {
                    quantityMap.remove(product.id)
                }
            }
        }

        holder.binding.etQuantity.addTextChangedListener(watcher)
        holder.textWatcher = watcher
    }

    override fun getItemCount(): Int = products.size
}