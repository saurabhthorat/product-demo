package com.saurabh.demo.data.network.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("product_name") var productName: String,
    var price: String,
    var company: String,
    val image: String
) : Serializable