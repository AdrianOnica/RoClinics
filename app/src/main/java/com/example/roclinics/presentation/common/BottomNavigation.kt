package com.example.roclinics.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roclinics.R
import com.example.roclinics.presentation.navigation.ScreenDestination

enum class BottomNavigationItems(val icon: Int, val screenDestination: ScreenDestination) {
    UserScreen(R.drawable.ic_home, ScreenDestination.UserScreen),
    DetailsScreen(R.drawable.ic_person, ScreenDestination.ProfileDetailsScreen)
}

@Composable
fun DisplayBottomNavigation(
    screenSelected: BottomNavigationItems,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp )
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        BottomNavigationItems.values().forEach { item ->
            Image(
                painter = painterResource(id = item.icon) ,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .weight(1f)
                    .clickable {
                        navigateTo(navController,item.screenDestination)
                    }
            )
        }
    }
}