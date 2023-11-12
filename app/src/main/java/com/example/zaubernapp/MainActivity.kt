package com.example.zaubernapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zaubernapp.ui.general.GeneralAppScreen
import com.example.zaubernapp.ui.theme.ZaubernAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZaubernAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "/"
                ) {
                    composable("/") {
                        GeneralAppScreen()
                    }
                }
            }
        }
    }
}
