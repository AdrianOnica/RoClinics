package com.example.roclinics.presentation.auth

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roclinics.R
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.navigateTo
import com.example.roclinics.presentation.navigation.ScreenDestination
import com.example.roclinics.ui.theme.montserrat_light

@Composable
fun ClientSignUpScreen(
    navController: NavController,
    viewModel: AppViewModel
) {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val firstnameState = remember { mutableStateOf(TextFieldValue()) }
    val lastnameState = remember { mutableStateOf(TextFieldValue()) }
    //  CheckSignedIn(navController = navController, viewModel = viewModel)
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
                    text = "SignUp",
                    modifier = Modifier.padding(start = 29.dp, bottom = 30.dp),
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 29.sp,
                    fontFamily = FontFamily.Serif
                )
                TextField(
                    value = firstnameState.value,
                    onValueChange = { firstnameState.value = it },
                    modifier = Modifier
                        .padding(end = 23.dp, bottom = 15.dp, start = 20.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "First Name",
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
                    value = lastnameState.value,
                    onValueChange = { lastnameState.value = it },
                    modifier = Modifier
                        .padding(end = 23.dp, bottom = 15.dp, start = 20.dp)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Last Name",
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
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    modifier = Modifier
                        .padding(end = 23.dp, bottom = 15.dp, start = 20.dp)
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
                        viewModel.onSignUp(emailState.value.text, passwordState.value.text)
                        viewModel.createOrUpdateProfile(
                            email = emailState.value.text,
                            firstName = firstnameState.value.text,
                            lastName = lastnameState.value.text
                        )


                    },
                    Modifier
                        .padding(23.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.LightGreen),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Text(text = "SignUp")
                }
                Text(
                    text = "Already have and account?",
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 5.dp)
                        .clickable { navigateTo(navController, ScreenDestination.LoginScreen) }
                )

                Row(Modifier.padding(top = 8.dp)) {
                    Divider(
                        thickness = 1.dp, color = Color.White, modifier = Modifier
                            .width(25.dp)
                            .padding(top = 10.dp)
                    )
                    Text(
                        text = "Register your clinic",
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp, bottom = 5.dp)
                            .clickable { navigateTo(navController, ScreenDestination.LoginScreen) }
                    )
                    Divider(
                        thickness = 1.dp, color = Color.White, modifier = Modifier
                            .width(29.dp)
                            .padding(top = 12.dp, start = 5.dp)
                    )
                }
            }
        }
    }
}

