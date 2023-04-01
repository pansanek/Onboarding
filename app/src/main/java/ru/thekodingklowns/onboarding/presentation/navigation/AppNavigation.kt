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
import map.ImageZoom
import ru.thekodingklowns.onboarding.presentation.navigation.screens.AppScreen
import ru.thekodingklowns.onboarding.presentation.navigation.screens.AppTab
import ru.thekodingklowns.onboarding.presentation.screens.users.Users
import ru.thekodingklowns.onboarding.presentation.viewmodel.viewModelScopedTo

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
        startDestination = AppTab.Users.route
    ) {
        users()

        map()

        quizzes()

        profile()
    }
}

fun NavGraphBuilder.users() {
    navigation(
        route = AppTab.Users.route,
        startDestination = AppTab.Users.startDestination
    ) {
        composable(
            route = AppScreen.Users.route
        ) {
            Users(it.viewModelScopedTo(AppTab.Users.route))
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
            ImageZoom()
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