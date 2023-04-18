package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name ){
        // This is where we build nav graph this is where we put together decompose the bowls
        composable(MovieScreens.HomeScreen.name){
        // to get actual name
            // here we pass where this should lead us to
            HomeScreen(navController=navController)

        }

         //www.google.com/detail-screen/id = 34
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
        arguments = listOf(navArgument(name = "movie"){type= NavType.StringType})){
            backStackEntry->

            DetailsScreen(navController=navController,
            backStackEntry.arguments?.getString("movie"))
        }
    }
    // we could just wrote a string that contains homescreen
}