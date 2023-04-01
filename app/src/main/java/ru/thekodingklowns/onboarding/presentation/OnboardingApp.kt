package ru.thekodingklowns.onboarding.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.thekodingklowns.onboarding.presentation.navigation.AppNavigation
import ru.thekodingklowns.onboarding.presentation.navigation.LocalNavController
import ru.thekodingklowns.onboarding.presentation.navigation.screens.AppTab

@Composable
fun OnboardingApp() {
    val navController = LocalNavController.current

    Scaffold(
        topBar = {
            // when...
        },
        content = {
            Box(
                modifier = Modifier.padding(it)
            ) {
                AppNavigation(navController)
            }
        },
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            NavigationBar {
                AppTab.tabs.forEach { tab ->
                    val isSelected = currentDestination?.hierarchy?.any { it.route == tab.route } == true
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (isSelected) {
                                navController.popBackStack(
                                    route = tab.startDestination,
                                    inclusive = false
                                )
                                return@NavigationBarItem
                            }
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true

                                // We want to reset the graph if it is clicked while already selected
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(tab.icon, stringResource(tab.resourceId))
                        }
                    )
                }
            }
        }
    )
}