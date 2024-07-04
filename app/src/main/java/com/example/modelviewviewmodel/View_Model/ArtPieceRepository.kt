package com.example.modelviewviewmodel.View_Model
import com.example.modelviewviewmodel.Model.ArtPiece

interface ArtPieceRepository {
    suspend fun getAllArtPieces(): List<ArtPiece>
    suspend fun getArtPieceById(id: Int): ArtPiece?
    suspend fun insertArtPiece(artPiece: ArtPiece)
    suspend fun updateArtPiece(artPiece: ArtPiece)
    suspend fun deleteArtPiece(artPiece: ArtPiece)
}
