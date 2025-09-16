package com.practicum.moodnotes.data

data class MoodNote(
    val id: Int,
    val text: String,
    val images: String,
    val timestamp: Long = System.currentTimeMillis()
)
