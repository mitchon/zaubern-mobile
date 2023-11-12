package com.example.zaubernapp.ui.general

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.zaubernapp.ui.screens.home.HomeScreen
import com.example.zaubernapp.ui.screens.product.ProductScreen
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralAppScreen(
    viewModel: GeneralViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStateEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            GeneralTopAppBar(
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
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
                .background(MaterialTheme.colorScheme.primaryContainer),
        ) {
            NavHost(
                navController = navController,
                startDestination = ("/home")
            ) {
                composable(route = "/home") {
                    viewModel.setCanDropDown(true)
                    HomeScreen(
                        onProductClicked = {
                            Log.i("backStack", "${navController.currentBackStack.value.map { it.destination }}")
                            navController.navigate("/product/$it")
                            viewModel.setCanNavigateUp(navController.previousBackStackEntry != null)
                        }
                    )
                }
                composable(route = "/product/{productId}") { navBackEntry ->
                    viewModel.setCanDropDown(false)
                    val productId = UUID.fromString(navBackEntry.arguments?.getString("productId"))
                    ProductScreen(productId = productId)
                }
            }
        }
    }
}