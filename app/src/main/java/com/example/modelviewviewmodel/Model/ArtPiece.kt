package com.example.modelviewviewmodel.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "art_piece")
data class ArtPiece(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String,
    val description: String,
    val price: Double
)
