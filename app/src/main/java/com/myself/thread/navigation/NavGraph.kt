package com.myself.thread.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myself.thread.screens.AddThread
import com.myself.thread.screens.BottomNav
import com.myself.thread.screens.Home
import com.myself.thread.screens.Notifications
import com.myself.thread.screens.Profile
import com.myself.thread.screens.Search
import com.myself.thread.screens.Splash

@Composable
fun NavGraph(navController: NavHostController) {
    // navigation
    NavHost(navController = navController, startDestination = Routes.Splash.routes) {
        composable(Routes.Splash.routes) {
            Splash(navController)
        }
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
        composable(Routes.BottomNav.routes) {
            BottomNav(navController)
        }
    }
}
