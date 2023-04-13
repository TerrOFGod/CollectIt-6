package com.example.collectit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.collectit.navigation.NavRoute
import com.example.collectit.navigation.NotesNavHost
import com.example.collectit.ui.components.BasicImageComponent.Companion.BasicImageComponent
import com.example.collectit.ui.theme.CollectItTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CollectItTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotesNavHost()
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
    NavRoute.Video
)

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
                AssistChip(
                    onClick = { navController.navigate(NavRoute.path) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }},
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = NavRoute.icon!!),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp,35.dp)
                        )
                    },
                    label = {
                        Text(
                            text = NavRoute.title,
                            fontSize = 25.sp,
                        )
                    }
                )
            }
        }
    }
}

fun Icon(imageVector: Painter, id: Int) {
    imageVector
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
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
                                    NotesNavHost()
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