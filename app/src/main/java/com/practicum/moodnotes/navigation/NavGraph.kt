package com.practicum.moodnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.practicum.moodnotes.screens.AddMoodScreen
import com.practicum.moodnotes.screens.MoodListScreen
import com.practicum.moodnotes.viewModel.MoodViewModel
import androidx.navigation.compose.composable

@Composable
fun MoodNotesNavGraph(viewModel: MoodViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mood_list") {
        composable("mood_list") {
            MoodListScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate("add_mood") }
            )
        }
        composable("add_mood") {
            AddMoodScreen(
                viewModel = viewModel,
                onNoteAdded = { navController.popBackStack() }
            )
        }
    }
}