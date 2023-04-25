package com.example.collectit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.collectit.navigation.CollectItNavHost
import com.example.collectit.navigation.NavRoute
import com.example.collectit.ui.components.NavButtonWithIcon.Companion.NavButtonWithIcon
import com.example.collectit.ui.components.NavButtonWithoutIcon.Companion.NavButtonWithoutIcon
import com.example.collectit.ui.theme.CollectItTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CollectItTheme {
                // A surface container using the 'background' color from the theme
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val drawerState = remember { mutableStateOf(DrawerValue.Closed) }
                    val context = LocalContext.current
                    Column {
                        Scaffold(
                            floatingActionButton = {
                                FloatingActionButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            },
                            topBar = {
                                TopAppBar(
                                    title = {
                                        Text(text = "Collect It")
                                    },
                                    navigationIcon = {
                                        IconButton(onClick = {
                                            if (drawerState.value == DrawerValue.Closed) {
                                                drawerState.value = DrawerValue.Open
                                            } else {
                                                drawerState.value = DrawerValue.Closed
                                            }
                                        }){
                                            Icon(
                                                imageVector = Icons.Outlined.Menu,
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    actions = {
                                        IconButton(onClick = { /*TODO*/ }) {
                                            Icon(
                                                imageVector = Icons.Outlined.Search,
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    colors = topAppBarColors(
                                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                        titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                )
                            },
                            content = {innerPadding ->
                                BoxWithConstraints{

                                    Box (modifier = Modifier.padding(innerPadding)){
                                        Column {
                                            CollectItNavHost(navController = navController)
                                        }
                                        if(drawerState.value != DrawerValue.Open) {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth(0.5f)
                                                    .fillMaxHeight()
                                            ) {
                                                SidePanel()
                                            }
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

val items = listOf(
    NavRoute.Home,
    NavRoute.Profile,
    NavRoute.Images,
    NavRoute.Music,
    NavRoute.Video,
    NavRoute.Login
)

@ExperimentalMaterial3Api
@Preview
@Composable
fun SidePanel() {
    var navController = rememberNavController()
    return Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.outline
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items.forEach { NavRoute ->
                if (NavRoute.icon != null){
                    NavButtonWithIcon(navController, NavRoute)
                }else{
                    NavButtonWithoutIcon(navController, NavRoute)
                }
            }
        }
    }
}