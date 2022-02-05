package com.example.roclinics.presentation.main

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.BackIcon
import com.example.roclinics.presentation.common.CustomRezervationTextField
import com.example.roclinics.presentation.common.CustomTextField
import com.example.roclinics.presentation.navigation.ScreenDestination
import java.util.*

object Specialitate {
    val expertises = listOf("Radiologie", "Ginecologie", "Stomatologie")
}

@Composable
fun RezervationDetailScreen(navController: NavController, viewModel: AppViewModel) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val dateTime = remember { mutableStateOf("") }
    val openCalendarState = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .wrapContentHeight()
                .background(AppColors.DarkBlue)
        ) {
            TopAppBar(backgroundColor = Color.Blue, contentColor = Color.White) {
                BackIcon(navController = navController)
                Text(text = "Introduce-ti detaliile", fontSize = 20.sp)
            }
            Column(
                Modifier
                    .fillMaxSize()
            ) {
                InfoBox()

                CustomTextField(
                    value = lastName.value,
                    onValueChange = { lastName.value = it },
                    label = { Text(text = "Nume",color = Color.White) },
                    enabled = true,
                )
                CustomTextField(
                    value = firstName.value,
                    onValueChange = { firstName.value = it },
                    label = { Text(text = "Prenume",color = Color.White) },
                    enabled = true,

                    )

                CustomTextField(
                    value = phoneNumber.value,
                    onValueChange = { lastName.value = it },
                    label = { Text(text = "Numar de telefon",color = Color.White) },
                    enabled = true,
                )

                CustomTextField(
                    value = dateTime.value,
                    onValueChange = { dateTime.value = it },
                    label = { Text(text = "Data",color = Color.White) },
                    enabled = false
                ) {
                        openCalendarState.value = true
                    }

                if (openCalendarState.value) {
                    DisplayCalendar(context = LocalContext.current, showDate = dateTime)
                    openCalendarState.value = false
                }
                Button(
                    onClick = {
                    },
                    Modifier
                        .padding(23.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.LightGreen),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Text(text = "Programeaza-te")
                }
            }
        }
    }
}

//Small box with Clinic's informations
@Composable
fun InfoBox() {
    val expertise = remember { mutableStateOf("") }
    val doctor = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        elevation = 8.dp,
        color = AppColors.DarkBlue
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column() {

                Text(text = "Clinica...", fontSize = 20.sp, color = Color.White)
                Text(text = "Adresa...", fontSize = 15.sp, color = Color.White)
                Text(text = "Numar de telefon...", fontSize = 20.sp, color = Color.White)
            }
            Column(horizontalAlignment = Alignment.End) {
                CustomRezervationTextField(
                    value = expertise.value,
                    onValueChange = { expertise.value = it },
                    label = { Text(text = "Specializare",color = Color.White) },
                    enabled = true
                )
                CustomRezervationTextField(
                    value = doctor.value,
                    onValueChange = { doctor.value = it },
                    label = { Text(text = "Doctor",color = Color.White) },
                    enabled = true
                )

            }
        }

    }
}

@Composable
fun DisplayCalendar(context: Context, showDate: MutableState<String>) {

    val calendar = Calendar.getInstance()

    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.get(Calendar.MONTH)
    val year = calendar.get(Calendar.YEAR)
    calendar.time = Date()
    DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            showDate.value = "$day/$month/$year"
        }, day, month, year
    ).show()


}