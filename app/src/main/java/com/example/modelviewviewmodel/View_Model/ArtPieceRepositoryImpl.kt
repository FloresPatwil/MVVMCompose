package com.example.modelviewviewmodel.View_Model

import com.example.modelviewviewmodel.Model.ArtPiece
import com.example.modelviewviewmodel.Model.ArtPieceDao

class ArtPieceRepositoryImpl(private val artPieceDao: ArtPieceDao) : ArtPieceRepository {
    override suspend fun getAllArtPieces(): List<ArtPiece> {
        return artPieceDao.getAllArtPieces()
    }

    override suspend fun getArtPieceById(id: Int): ArtPiece? {
        return artPieceDao.getArtPieceById(id)
    }

    override suspend fun insertArtPiece(artPiece: ArtPiece) {
        artPieceDao.insertArtPiece(artPiece)
    }

    override suspend fun updateArtPiece(artPiece: ArtPiece) {
        artPieceDao.updateArtPiece(artPiece)
    }

    override suspend fun deleteArtPiece(artPiece: ArtPiece) {
        artPieceDao.deleteArtPiece(artPiece)
    }
}
