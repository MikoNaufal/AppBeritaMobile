package com.example.loginregister

import androidx.room.Entity

data class Concert(
    val id: Int,
    val nama: String,
    val tanggal: String,
    val tempat: String,
    val image: String
)
