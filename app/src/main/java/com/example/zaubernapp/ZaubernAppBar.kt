package com.example.zaubernapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZaubernAppBar(
    canNavigateUp: Boolean,
    canDropDown: Boolean,
    navigateUp: () -> Unit,
    showDropDown: () -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .topBarBorders()
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        title = {
            Icon(
                modifier = Modifier.height(24.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo"
            )
        },
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(
                    onClick = { navigateUp() }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "back"
                    )
                }
            }
        },
        actions = {
            if (canDropDown) {
                IconButton(onClick = { showDropDown() }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "menu"
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun topBarPreview() {
    ZaubernAppBar(canNavigateUp = true, canDropDown = true, navigateUp = { }, showDropDown = {})
}

fun Modifier.topBarBorders() = composed (
    factory = {
        val strokeWidth = LocalDensity.current.run { 2.dp.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidth/2
            drawLine(
                color = Color.Black,
                start = Offset(0f, strokeWidth/2),
                end = Offset(width, strokeWidth/2),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = Color.Black,
                start = Offset(0f, height),
                end = Offset(width, height),
                strokeWidth = strokeWidth
            )
        }
    }
)
