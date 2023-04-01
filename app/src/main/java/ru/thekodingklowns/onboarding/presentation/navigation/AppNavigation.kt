package ru.thekodingklowns.onboarding.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation
import com.mxalbert.sharedelements.LocalSharedElementsRootScope
import ru.thekodingklowns.onboarding.presentation.navigation.screens.AppScreen
import ru.thekodingklowns.onboarding.presentation.navigation.screens.AppTab

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(navBackStackEntry) {
        /*if (navBackStackEntry?.destination?.route == appBarViewModel.defaultTab.startDestination)
            appBarViewModel.setCurrentTab(appBarViewModel.defaultTab)*/
    }


    // Disabling system "Back" button during transition
    BackHandler(LocalSharedElementsRootScope.current!!.isRunningTransition) {}

    NavHost(
        navController = navController,
        startDestination = AppTab.Leaderboard.route
    ) {
        leaderboard()

        map()

        quizzes()

        profile()
    }
}

fun NavGraphBuilder.leaderboard() {
    navigation(
        route = AppTab.Leaderboard.route,
        startDestination = AppTab.Leaderboard.startDestination
    ) {
        composable(
            route = AppScreen.Leaderboard.route
        ) {

        }
    }
}

fun NavGraphBuilder.map() {
    navigation(
        route = AppTab.Map.route,
        startDestination = AppTab.Map.startDestination
    ) {
        composable(
            route = AppScreen.Map.route
        ) {

        }
    }
}

fun NavGraphBuilder.quizzes() {
    navigation(
        route = AppTab.Quizzes.route,
        startDestination = AppTab.Quizzes.startDestination
    ) {
        composable(
            route = AppScreen.Quizzes.route
        ) {

        }
    }
}

fun NavGraphBuilder.profile() {
    navigation(
        route = AppTab.Profile.route,
        startDestination = AppTab.Profile.startDestination
    ) {
        composable(
            route = AppScreen.Profile.route
        ) {

        }
    }
}