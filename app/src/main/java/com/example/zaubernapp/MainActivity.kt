package com.example.zaubernapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.zaubernapp.ui.theme.ZaubernAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZaubernAppTheme {
                ZaubernScreen()
            }
        }
    }
}
