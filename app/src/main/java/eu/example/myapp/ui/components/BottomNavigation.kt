package eu.example.myapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf("Home", "grid", "about")
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

    NavigationBar(
        containerColor = Color(0xFFFFC0CB) // Soft pink background
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen,
                onClick = { navController.navigate(screen) },
                icon = {
                    when (screen) {
                        "Home" -> Icon(Icons.Filled.Home, contentDescription = "Home", tint = if (currentRoute == screen) Color.Black else Color.Gray)
                        "grid" -> Icon(Icons.Filled.Menu, contentDescription = "Grid", tint = if (currentRoute == screen) Color.Black else Color.Gray)
                        "about" -> Icon(Icons.Filled.Info, contentDescription = "About", tint = if (currentRoute == screen) Color.Black else Color.Gray)
                    }
                },
                label = {
                    Text(
                        text = when (screen) {
                            "Home" -> "Home"
                            "grid" -> "Products"
                            "about" -> "About"
                            else -> ""
                        },
                        color = if (currentRoute == screen) Color.Black else Color.Gray // Set text color
                    )
                }
            )
        }
    }
}
