package com.peterfam.markit.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.peterfam.markit.feature_note.presentation.mark_details.component.MarkDetailsScreen
import com.peterfam.markit.feature_note.presentation.marks_list_screen.components.MarksScreen
import com.peterfam.markit.feature_note.presentation.util.Screen
import com.peterfam.markit.ui.app_theme.CleanArchMarkItTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchMarkItTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MarksScreen.route
                    ) {
                        composable(route = Screen.MarksScreen.route) {
                            MarksScreen(navController = navController)
                        }
                        composable(
                            route = Screen.MarkDetailsScreen.route +
                                    "?markId={markId}&markColor={markColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "markId",
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "markColor") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            val color = it.arguments?.getInt("markColor") ?: -1
                            MarkDetailsScreen(
                                navController = navController,
                                markColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}