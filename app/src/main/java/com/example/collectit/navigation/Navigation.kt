package com.example.collectit.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.collectit.ImageCard
import com.example.collectit.R
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
fun NotesNavHost(){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.Home.path){
        composable(NavRoute.Home.path){
            HomeScreen(navController = navController)
        }
        composable(NavRoute.Images.path){
            ImagesScreen(navController = navController)
        }
        composable(NavRoute.Music.path){
            MusicScreen(navController = navController)
        }
        composable(NavRoute.Video.path){
            VideoScreen(navController = navController)
        }
        composable(NavRoute.Profile.path){
            ProfileScreen(navController = navController)
        }
        composable(NavRoute.Add.path){
            AddScreen(navController = navController)
        }
        composable(NavRoute.Login.path){
            LoginScreen(navController = navController)
        }
        composable(
            route = "${NavRoute.Image.path}/{${NavRoute.Image.id}}",
            arguments = listOf(navArgument(NavRoute.Image.id.toString()) { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val gameCardId = arguments.getInt(NavRoute.Image.id.toString(), 0)
            if(gameCardId != 0)
                ImageCard(title = "Bacon ipsum", description = "Bacon ipsum Bacon ipsu mBacon ipsBacon ipsum Bacon ipsum umB acon ipsumB acon ipsum")
        }
    }
}

