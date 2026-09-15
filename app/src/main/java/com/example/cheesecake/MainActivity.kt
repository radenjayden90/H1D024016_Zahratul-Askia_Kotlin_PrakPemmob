package com.example.cheesecake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cheesecake.ui.screen.BasicInfoScreen
import com.example.cheesecake.ui.screen.HubungiKamiScreen
import com.example.cheesecake.ui.theme.JualanTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            JualanTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "basic_info",
        modifier = Modifier.fillMaxSize()
    ) {

        composable("basic_info") {
            BasicInfoScreen(
                onNavigateToContact = {
                    navController.navigate("form_screen")
                }
            )
        }

        composable("form_screen") {
            HubungiKamiScreen(
                navController = navController
            )
        }
    }
}