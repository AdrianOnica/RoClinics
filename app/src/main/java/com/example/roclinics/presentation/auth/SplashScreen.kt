package com.example.roclinics.presentation.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.navigateTo
import com.example.roclinics.presentation.navigation.ScreenDestination
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavController) {
    val startAnimation = remember { mutableStateOf(false) }
    val alphaAnim =
        animateFloatAsState(
            targetValue = if (startAnimation.value) 1f else 0f,
            animationSpec = tween(durationMillis = 3000)
        )
    LaunchedEffect(key1 = true) {
        startAnimation.value = true
        delay(4000)
       navController.navigate(ScreenDestination.LoginScreen.route){
           navController.popBackStack()
       }
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Logo icon",
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha),
            tint = Color.White
        )
    }
}