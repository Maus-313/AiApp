package com.example.aiapp

import android.graphics.Bitmap
import com.example.aiapp.data.Chat

data class ChatState(

    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? =    null

)