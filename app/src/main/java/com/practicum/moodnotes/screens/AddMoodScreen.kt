package com.practicum.moodnotes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.practicum.moodnotes.viewModel.MoodViewModel

@Composable
fun AddMoodScreen(viewModel: MoodViewModel, onNoteAdded: () -> Unit) {

    var text by remember { mutableStateOf("") }
    val imag = listOf("😊", "😢", "😡", "😴")
    var selectImages by remember { mutableStateOf("😊") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Добавьте заметку настроентя",
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = text,
            label = {
                Text(text = "Опишите своё настроение")
            },
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            imag.forEach { image ->
                Button(
                    onClick = { selectImages = image },
                    modifier = Modifier
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectImages == image) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        text = image,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Button(
                    onClick = {
                        if (text.isNotBlank()) {
                            viewModel.addNote(selectImages, text)
                            onNoteAdded()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = text.isNotBlank()
                ) {
                    Text(
                        text = "Сохранить"
                    )
                }
            }

        }
    }
}