package com.example.roclinics.presentation.navigation

sealed class ScreenDestination(val route: String){
    object SplashScreen : ScreenDestination("splash_screen")
    object LoginScreen : ScreenDestination("login_screen")
    object ClientSignUpScreen : ScreenDestination("client_signup_screem")
    object IntroductionScreen : ScreenDestination("introduction_screen")
    object UserScreen : ScreenDestination("user_screen")
    object ProfileDetailsScreen : ScreenDestination("profile_details_screen")
    object RezervationScreen : ScreenDestination("rezervation_screen")
    object RezervationDetailScreen : ScreenDestination("rezervation_detail_screen")
}
