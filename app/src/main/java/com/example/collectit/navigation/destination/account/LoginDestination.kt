package com.example.collectit.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.collectit.navigation.NavRoute
import com.example.collectit.screens.AddScreen
import com.example.collectit.screens.LoginScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.login(
    navController: NavHostController
){
    composable(NavRoute.Login.path){
        LoginScreen(navController = navController)
    }
}