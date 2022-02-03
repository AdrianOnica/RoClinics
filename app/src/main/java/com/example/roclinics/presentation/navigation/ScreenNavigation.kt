package com.example.roclinics.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.LoginScreen
import com.example.roclinics.presentation.auth.AnimatedSplashScreen
import com.example.roclinics.presentation.auth.ClientSignUpScreen
import com.example.roclinics.presentation.auth.IntroductionScreen
import com.example.roclinics.presentation.main.ProfileDetailsScreen
import com.example.roclinics.presentation.main.RezervationScreen
import com.example.roclinics.presentation.main.UserScreen


//@ExperimentalAnimationApi
@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val viewModel: AppViewModel = hiltViewModel<AppViewModel>()
    NavHost(
        navController = navController,
        startDestination = ScreenDestination.SplashScreen.route
    ) {
        composable(ScreenDestination.SplashScreen.route) {
            AnimatedSplashScreen(navController)
        }
        composable(ScreenDestination.LoginScreen.route) {
            LoginScreen(navController, viewModel)
        }
        composable(ScreenDestination.ClientSignUpScreen.route) {
            ClientSignUpScreen(navController, viewModel)
        }
        composable(ScreenDestination.IntroductionScreen.route) {
            IntroductionScreen(navController, viewModel)
        }
        composable(ScreenDestination.UserScreen.route) {
            UserScreen(navController, viewModel)
        }
        composable(ScreenDestination.ProfileDetailsScreen.route) {
            ProfileDetailsScreen(navController, viewModel)
        }
        composable(ScreenDestination.RezervationScreen.route) {
            RezervationScreen(navController, viewModel)
        }

    }
}
//TODO TASKS:
// CREATE THE USER INTERFACE FOR PROFILE SCREEN AND PROGRAM