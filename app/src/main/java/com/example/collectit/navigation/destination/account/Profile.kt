package com.example.collectit.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.collectit.navigation.NavRoute
import com.example.collectit.screens.ProfileScreen
import com.example.collectit.screens.VideoScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.profile(
    navController: NavHostController
){
    composable(NavRoute.Profile.path){
        ProfileScreen(navController = navController)
    }
}