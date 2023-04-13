package com.example.collectit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.collectit.navigation.NavRoute
import com.example.collectit.navigation.NotesNavHost
import com.example.collectit.ui.theme.CollectItTheme
import org.w3c.dom.Text

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(NavRoute.Add.path)}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "This will be first and main page.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevHomeScreen(){
    CollectItTheme {
        HomeScreen(navController = rememberNavController())
    }
}