package com.example.collectit.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.collectit.navigation.NavRoute
import com.example.collectit.screens.HomeScreen
import com.example.collectit.screens.ImagesScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.images(
    navController: NavHostController
){
    composable(NavRoute.Images.path){
        ImagesScreen(navController = navController)
    }
}