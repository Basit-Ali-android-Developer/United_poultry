package com.example.unitedpoultry.adminproduct.model

data class Product(
    val id: Int,
    val name: String,
    val packing: String,
    val eggs_count: Int,
    val price: String,
    val is_active: Int,
    var picked_quantity: Int=0

)

data class ProductData(
    val products: List<Product>
)
