package com.practicum.moodnotes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.moodnotes.data.MoodNote
import com.practicum.moodnotes.data.MoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoodViewModel @Inject constructor(private val repository: MoodRepository) : ViewModel() {
    val notes: StateFlow<List<MoodNote>> = repository.notes
    fun addNote(emojis: String, text: String) {
        viewModelScope.launch {
            val newId = (notes.value.maxOfOrNull { it.id } ?: 0) + 1
            repository.addNote(MoodNote(newId, emojis, text))
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }
}