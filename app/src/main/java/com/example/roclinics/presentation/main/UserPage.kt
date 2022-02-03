package com.example.roclinics.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.BottomNavigationItems
import com.example.roclinics.presentation.common.DisplayBottomNavigation
import com.example.roclinics.presentation.common.navigateTo
import com.example.roclinics.presentation.navigation.ScreenDestination
import com.example.roclinics.ui.theme.cabin_regular

@Composable
fun UserScreen(navController: NavController, viewModel: AppViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
    ) {
        Column() {
            Column(modifier = Modifier.weight(1f)) {
                TopAppBar(
                    contentPadding = PaddingValues(8.dp),
                    contentColor = Color.White,
                    backgroundColor = AppColors.DarkBlue,
                    elevation = 12.dp
                )
                {
                    Text(
                        text = "Programari",
                        fontSize = 25.sp,
                        fontFamily = cabin_regular,
                        modifier = Modifier.padding(start = 18.dp)
                    )
                }
                RezervationDisplay {
                        navigateTo(navController,ScreenDestination.RezervationScreen)
                }
            }
            DisplayBottomNavigation(
                screenSelected = BottomNavigationItems.UserScreen,
                navController = navController
            )
        }

    }
}

@Composable
fun RezervationDisplay(onclick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .height(75.dp)
            .clip(shape = RoundedCornerShape(26.dp))
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(listOf(Color.Gray, Color.Gray)),
                shape = RoundedCornerShape(28.dp)
            )
            .clickable { onclick.invoke() }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Programeaza-te aici", color = Color.White, fontSize = 18.sp)
        }
    }
}