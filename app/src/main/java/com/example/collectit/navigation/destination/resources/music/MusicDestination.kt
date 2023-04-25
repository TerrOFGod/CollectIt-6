package com.example.collectit.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.collectit.navigation.NavRoute
import com.example.collectit.screens.ImagesScreen
import com.example.collectit.screens.MusicScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.music(
    navController: NavHostController
){
    composable(NavRoute.Music.path){
        MusicScreen(navController = navController)
    }
}