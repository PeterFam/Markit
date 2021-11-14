package com.peterfam.markit.feature_note.presentation.util

sealed class Screen(
    val route: String
) {
    object MarksScreen : Screen("marks_screen")
    object MarkDetailsScreen : Screen("mark_details_screen")
}
