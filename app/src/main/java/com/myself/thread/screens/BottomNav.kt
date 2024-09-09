package com.myself.thread.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.myself.thread.models.BottomNavItems
import com.myself.thread.navigation.Routes

// @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(navController: NavHostController) {
    val navController1 = rememberNavController()
    Scaffold(bottomBar = { MyBottomBar(navController1) }) {
            innerPadding ->
        NavHost(
            navController1,
            startDestination = Routes.Home.routes,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Routes.Home.routes) {
                Home()
            }
            composable(Routes.Search.routes) {
                Search()
            }
            composable(Routes.AddThreads.routes) {
                AddThread()
            }
            composable(Routes.Notification.routes) {
                Notifications()
            }
            composable(Routes.Profile.routes) {
                Profile()
            }
        }
    }
}

@Composable
fun MyBottomBar(navController1: NavHostController) {
    // this will find the current stack of bottom bar page list
    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItems(
            "Home",
            Routes.Home.routes,
            Icons.Rounded.Home,
        ),
        BottomNavItems(
            "Search",
            Routes.Search.routes,
            Icons.Rounded.Search,
        ),
        BottomNavItems(
            "AddThreads",
            Routes.AddThreads.routes,
            Icons.Rounded.AddCircle,
        ),
        BottomNavItems(
            "Notification",
            Routes.Notification.routes,
            Icons.Rounded.Notifications,
        ),
        BottomNavItems(
            "Profile",
            Routes.Profile.routes,
            Icons.Rounded.Person,
        ),

    )
    BottomAppBar {
        list.forEach {
            val selected = it.route == backStackEntry?.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController1.navigate(it.route) {
                        popUpTo(navController1.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = it.icon, contentDescription = it.title)
                },
            )
        }
    }
}
