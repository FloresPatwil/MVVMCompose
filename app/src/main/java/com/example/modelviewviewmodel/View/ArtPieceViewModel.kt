package com.example.modelviewviewmodel.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modelviewviewmodel.Model.ArtPiece
import com.example.modelviewviewmodel.View_Model.ArtPieceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ArtPieceViewModel(private val artPieceRepository: ArtPieceRepository) : ViewModel() {
    private val _artPieces = MutableStateFlow<List<ArtPiece>>(emptyList())
    val artPieces: StateFlow<List<ArtPiece>> = _artPieces.asStateFlow()

    init {
        loadArtPieces()
    }

    fun loadArtPieces() {
        viewModelScope.launch {
            _artPieces.value = artPieceRepository.getAllArtPieces()
        }
    }

    fun getArtPieceById(id: Int): ArtPiece? {
        return runBlocking {
            artPieceRepository.getArtPieceById(id)
        }
    }

    fun insertArtPiece(artPiece: ArtPiece) {
        viewModelScope.launch {
            artPieceRepository.insertArtPiece(artPiece)
            loadArtPieces()
        }
    }

    fun updateArtPiece(artPiece: ArtPiece) {
        viewModelScope.launch {
            artPieceRepository.updateArtPiece(artPiece)
            loadArtPieces()
        }
    }

    fun deleteArtPiece(artPiece: ArtPiece) {
        viewModelScope.launch {
            artPieceRepository.deleteArtPiece(artPiece)
            loadArtPieces()
        }
    }
}
