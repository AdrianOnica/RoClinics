package com.example.roclinics.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roclinics.R
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.CheckSignedIn
import com.example.roclinics.presentation.common.navigateTo
import com.example.roclinics.presentation.navigation.ScreenDestination
import com.example.roclinics.ui.theme.montserrat_extralightItalic
import com.example.roclinics.ui.theme.montserrat_light
import com.example.roclinics.ui.theme.montserrat_thinItalic
import com.example.roclinics.ui.theme.openSans

@Composable
fun LoginScreen(navController: NavController,viewModel: AppViewModel) {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    CheckSignedIn(navController = navController, viewModel = viewModel )
    Box(
        Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.padding(top = 35.dp)) {
            Row(Modifier.padding(start = 20.dp, top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .background(Color.White)
                        .padding(end = 8.dp)
                )
                Text(
                    text = "RoClinics",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontFamily = FontFamily.Serif
                )
            }
            Spacer(modifier = Modifier.height(65.dp))

            Column(
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(start = 29.dp, bottom = 20.dp),
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 29.sp,
                    fontFamily = FontFamily.Serif
                )
                TextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    modifier = Modifier
                        .padding(23.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Email",
                            color = Color.White,
                            fontFamily = montserrat_light,
                            fontSize = 16.sp
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        textColor = Color.White
                    )
                )
                TextField(
                    value = passwordState.value,
                    onValueChange = { passwordState.value = it },
                    modifier = Modifier
                        .padding(end = 23.dp, bottom = 15.dp, start = 20.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Password",
                            color = Color.White,
                            fontFamily = montserrat_light
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        textColor = Color.White
                    ), visualTransformation = PasswordVisualTransformation()
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Button(
                    onClick = {
                        viewModel.onSignIn(emailState.value.text, passwordState.value.text)
                              //if(viewModel.signedIn.value) {
                                  navController.navigate(ScreenDestination.IntroductionScreen.route) {
                                      navController.popBackStack()
                                  }
                              //}
                              },
                    Modifier
                        .padding(23.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.LightGreen),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Text(text = "Login")
                }
                Text(
                    text = "I dont have an account",
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 5.dp)
                        .clickable {
                            navigateTo(navController, ScreenDestination.ClientSignUpScreen)
                        })
            }
        }
    }
}

