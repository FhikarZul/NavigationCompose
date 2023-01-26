package com.example.navigationcompose

sealed class RouteScreen(val route: String){
    object MainScreen : RouteScreen("main_screen")
    object DetailScreen : RouteScreen("detail_screen")
    object DetailScreenDialog : RouteScreen("detail_screen_dialog")

    fun withArgs(vararg args: String) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
