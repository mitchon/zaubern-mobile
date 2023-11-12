package com.example.zaubernapp

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zaubernapp.ui.views.screens.ProductScreen
import com.example.zaubernapp.ui.views.screens.ProductsListScreen
import com.example.zaubernapp.viewmodels.GeneralViewModel
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZaubernScreen(
    viewModel: GeneralViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStateEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            ZaubernAppBar(
                canNavigateUp = uiState.canNavigateUp,
                canDropDown = uiState.canDropDown,
                navigateUp = {
                    navController.popBackStack()
                    viewModel.setCanNavigateUp(navController.previousBackStackEntry != null)
                },
                showDropDown = {}
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ("/"),
            modifier = Modifier.padding(
                start = 30.dp,
                end = 30.dp,
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding()
            )
        ) {
            composable(route = "/") {
                viewModel.setCanDropDown(true)
                ProductsListScreen(
                    onProductClicked = {
                        navController.navigate("/$it")
                        viewModel.setCanNavigateUp(navController.previousBackStackEntry != null)
                    }
                )
            }
            composable(route = "/{productId}") { navBackEntry ->
                viewModel.setCanDropDown(false)
                val productId = UUID.fromString(navBackEntry.arguments?.getString("productId"))
                ProductScreen(productId = productId)
            }
        }
    }
}