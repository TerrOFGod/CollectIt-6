package com.example.collectit.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.collectit.navigation.NavRoute
import com.example.collectit.ui.components.BasicImageComponent
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalMaterial3Api
@Composable
fun ImagesScreen(navController: NavHostController) {
    LazyColumn {
        items(20) {
            BasicImageComponent.BasicImageComponent(
                onClick = {navController.navigate("${NavRoute.Image.path}/{${NavRoute.Image.id}}")},
                url = "//images.ctfassets.net/yadj1kx9rmg0/wtrHxeu3zEoEce2MokCSi/cf6f68efdcf625fdc060607df0f3baef/quwowooybuqbl6ntboz3.jpg",
                title = "Bacon ipsum",
                date = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}