package com.example.modelviewviewmodel.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArtPieceDao {
    @Query("SELECT * FROM art_piece")
    suspend fun getAllArtPieces(): List<ArtPiece>

    @Query("SELECT * FROM art_piece WHERE id = :id")
    suspend fun getArtPieceById(id: Int): ArtPiece?

    @Insert
    suspend fun insertArtPiece(artPiece: ArtPiece)

    @Update
    suspend fun updateArtPiece(artPiece: ArtPiece)

    @Delete
    suspend fun deleteArtPiece(artPiece: ArtPiece)
}
