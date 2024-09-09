package com.myself.thread.navigation

sealed class Routes(val routes: String) {
    object Home : Routes("home")
    object Notification : Routes("notification")
    object Profile : Routes("profile")
    object Splash : Routes("splash")
    object AddThreads : Routes("addThreads")
    object Search : Routes("search")
    object BottomNav : Routes("bottom_nav")
}
