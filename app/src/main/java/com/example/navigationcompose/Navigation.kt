package com.example.navigationcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RouteScreen.MainScreen.route
    ) {
        composable(
            route = RouteScreen.MainScreen.route
        ) {
            MainScreen(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                navController = navController
            )
        }

        dialog(
            route = RouteScreen.DetailScreenDialog.route + "/{name}",
            arguments = listOf(
                navArgument(
                    "name"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ){
            DetailScreen(
                modifier = Modifier.fillMaxWidth(),
                name = it.arguments?.getString("name"),
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = RouteScreen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument(
                    "name"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {
            DetailScreen(
                modifier = Modifier.fillMaxWidth(),
                name = it.arguments?.getString("name"),
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}