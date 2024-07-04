package com.example.modelviewviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modelviewviewmodel.Model.ArtPiece
import com.example.modelviewviewmodel.View.ArtPieceViewModel
import com.example.modelviewviewmodel.ui.theme.ModelViewViewmodelTheme

class MainActivity : ComponentActivity() {
    private val artPieceViewModel: ArtPieceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModelViewViewmodelTheme {
                ArtPieceScreen(artPieceViewModel)
            }
        }
    }
}

@Composable
fun ArtPieceScreen(artPieceViewModel: ArtPieceViewModel) {
    val artPieces by artPieceViewModel.artPieces.collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        ArtPieceList(
            artPieces = artPieces,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun ArtPieceList(
    artPieces: List<ArtPiece>,
    modifier: Modifier = Modifier
) {
    // Implementa la lista de obras de arte aquí
    artPieces.forEach { artPiece ->
        Text(
            text = artPiece.author,
            modifier = modifier.padding(16.dp)
        )
    }
}
