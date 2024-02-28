package com.example.aiapp

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel@Inject constructor(
//    uriReader: UriReader
) : ViewModel() {

//    var state by mutableStateOf(MainState())
//        private set

    fun onImageSelected(uri: Uri){
        viewModelScope.launch {
//            state = state.copy(
//                selectedImageBitMap = uriReader.
//            )
        }
    }
}