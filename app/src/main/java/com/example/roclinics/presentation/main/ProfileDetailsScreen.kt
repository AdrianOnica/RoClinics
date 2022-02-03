package com.example.roclinics.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.BottomNavigationItems
import com.example.roclinics.presentation.common.DisplayBottomNavigation

@Composable
fun ProfileDetailsScreen(
    navController: NavController,
    viewModel: AppViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
    ) {
        Column() {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Profile Screen Details", color = Color.White)
            }
            DisplayBottomNavigation(
                screenSelected = BottomNavigationItems.DetailsScreen,
                navController = navController
            )
        }

    }
}

