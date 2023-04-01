package ru.thekodingklowns.onboarding.presentation.navigation.screens

import androidx.annotation.StringRes
import ru.thekodingklowns.onboarding.R

sealed class AppScreen(
    @StringRes val screenNameResource: Int,
    val route: String,
    val navLink: String = route.substringBefore("/{")
) {
    object Users: AppScreen(R.string.screen_users, "leaderboard")


    object Map: AppScreen(R.string.screen_map, "map")


    object Quizzes: AppScreen(R.string.screen_quizzes, "quizzes")


    object Profile: AppScreen(R.string.screen_profile, "profile")
}
