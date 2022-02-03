package com.example.roclinics.presentation.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.roclinics.data.ListOfCityAndTown
import com.example.roclinics.data.ListOfCityAndTown.listOfCities
import com.example.roclinics.data.ListOfCityAndTown.listOfTowns
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.CustomDialog
import com.example.roclinics.presentation.common.CustomTextField
import com.example.roclinics.presentation.navigation.ScreenDestination
import com.example.roclinics.ui.theme.cabin_regular
import com.example.roclinics.ui.theme.montserrat_light
import com.example.roclinics.ui.theme.openSans

//@Preview
@Composable
fun IntroductionScreen(
    navController: NavController, viewModel: AppViewModel
) {
    val phoneNumberState = remember { mutableStateOf(TextFieldValue()) }
    val cityState = remember { mutableStateOf("") }
    val townState = remember { mutableStateOf("") }
    val openDialogState1 = remember { mutableStateOf(false) }
    val openDialogState2 = remember { mutableStateOf(false) }
    Box(
        Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
    ) {

        Column() {
            Text(
                text = "Pentru a gasi clinicile din apropierea dumneavostra trebuie sa introduceti numarul de telefon si sa selectati locatia.",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 35.dp),
                fontSize = 26.sp,
                fontFamily = cabin_regular,
            )

            TextField(
                value = phoneNumberState.value,
                onValueChange = { phoneNumberState.value = it },
                modifier = Modifier
                    .padding(end = 23.dp, bottom = 15.dp, start = 20.dp)
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = "Numar de telefon",
                        color = Color.White,
                        fontFamily = montserrat_light
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    textColor = Color.White
                ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )
            CustomTextField(value = cityState.value, onValueChange = { cityState.value = it },
                label = {
                    Text(
                        text = "Judet",
                        color = Color.White,
                        fontFamily = montserrat_light
                    )
                }) {
                openDialogState1.value = true
            }
            if (openDialogState1.value) {
                CustomDialog(openDialogState1, cityState, listOfCities) {
                    openDialogState1.value = false
                }
            }

            CustomTextField(value = townState.value, onValueChange = { townState.value = it },
                label = {
                    Text(
                        text = "Oras",
                        color = Color.White,
                        fontFamily = montserrat_light
                    )
                }) {
                openDialogState2.value = true
            }
            if (openDialogState2.value) {
                CustomDialog(openDialogState2, townState, listOfTowns) {
                    openDialogState2.value = false
                }
            }

        }

        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            FloatingActionButton(
                onClick = {
                    viewModel.createOrUpdateProfile(
                        city = cityState.value,
                        town = townState.value,
                        phoneNumber = phoneNumberState.value.text
                    )
                    viewModel.completeInformation.value = true
                    navController.navigate(ScreenDestination.UserScreen.route){
                        navController.popBackStack()
                    }
                },
                contentColor = AppColors.LightGreen,
                modifier = Modifier.padding(23.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "floating action button icon",
                    tint = Color.Black
                )
            }
        }

    }
}

