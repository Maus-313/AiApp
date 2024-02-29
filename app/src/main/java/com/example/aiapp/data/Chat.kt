package com.example.aiapp.data

import android.graphics.Bitmap

data class Chat (

    val prompt: String,
    val bitmap: Bitmap?, // for image
    val isFromUser: Boolean // to know if it's Ai or User

)