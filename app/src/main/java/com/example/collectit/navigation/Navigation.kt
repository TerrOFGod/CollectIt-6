package com.example.collectit.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.collectit.ImageCard
import com.example.collectit.R
import com.example.collectit.navigation.destination.*
import com.example.collectit.screens.*

sealed class NavRoute(var path: String, var id: Int?, var icon: Int?, var title: String) {
    object Home : NavRoute("home/", null, R.drawable.home_48, "Home")
    object Images : NavRoute("images/", null, R.drawable.image_48, "Images")
    object Image : NavRoute("images/", 1, null, "Images")
    object Music : NavRoute("music/", null, R.drawable.music_48, "Music")
    object Video : NavRoute("video/", null, R.drawable.video_48, "Video")
    object Profile : NavRoute("profile/", null, R.drawable.person_48, "Profile")
    object Add : NavRoute("add/", null, R.drawable.add_48, "Add")
    object Login : NavRoute("login/", null, null, "Login")
}

@ExperimentalMaterial3Api
@Composable
fun CollectItNavHost(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = NavRoute.Home.path){
        home(navController)
        images(navController)
        music(navController)
        video(navController)
        profile(navController)
        add(navController)
        login(navController)
        image(navController)
    }
}

