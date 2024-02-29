package com.example.aiapp.data

import android.graphics.Bitmap
import android.hardware.biometrics.BiometricPrompt
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.ResponseStoppedException
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {

    private const val apikey = "AIzaSyAJxibsfx8KUdkHKL30d2mXNrwXz9OD584"


    // this for text
    suspend fun getResponse(prompt: String): Chat{

        val generativeModel = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apikey
        )

        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(prompt)
            }

            return Chat(
                prompt = response.text ?: "Error",
                bitmap = null,
                isFromUser = false
            )
        } catch(e: ResponseStoppedException){
            return Chat(
                prompt = e.message ?: "Error",
                bitmap = null,
                isFromUser = false
            )
        }
    }

    // this for bitmap(Image)
    suspend fun getResponseWithImage(prompt: String, bitmap: Bitmap): Chat{

        val generativeModel = GenerativeModel(
            modelName = "gemini-pro-vision",
            apiKey = apikey
        )

        // this is an important line
        val inputContent = content {
            image(bitmap)
            text(prompt)
        }

        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(inputContent)
            }

            return Chat(
                prompt = response.text ?: "Error",
                bitmap = null,
                isFromUser = false
            )
        } catch(e: ResponseStoppedException){
            return Chat(
                prompt = e.message ?: "Error",
                bitmap = null,
                isFromUser = false
            )
        }
    }


}