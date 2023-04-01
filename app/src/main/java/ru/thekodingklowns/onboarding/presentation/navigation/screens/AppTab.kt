package ru.thekodingklowns.onboarding.presentation.navigation.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import ru.thekodingklowns.onboarding.R

sealed class AppTab(
    val route: String,
    val startDestination: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Users: AppTab("tab_users", AppScreen.Users.route, R.string.screen_users, Icons.Default.Leaderboard)

    object Map: AppTab("tab_map", AppScreen.Map.route, R.string.screen_map, Icons.Default.Navigation)

    object Quizzes: AppTab("tab_quizzes", AppScreen.Quizzes.route, R.string.screen_quizzes, Icons.Default.School)

    object Profile: AppTab("tab_profile", AppScreen.Profile.route, R.string.screen_profile, Icons.Default.Person)

    companion object {
        val tabs: List<AppTab>
            get() = listOf(
                Users,
                Map,
                Quizzes,
                Profile
            )
    }
}
