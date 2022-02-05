package com.example.roclinics.presentation.main

import android.widget.SearchView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.common.AppColors
import com.example.roclinics.presentation.common.BackIcon
import com.example.roclinics.presentation.common.navigateTo
import com.example.roclinics.presentation.navigation.ScreenDestination

object List {
    val listoOfNames = listOf("Clinica Sante", "Clinica Union", "Clinica Palade", "Clinica Irina")
}

@Composable
fun RezervationScreen(navController: NavController, viewModel: AppViewModel) {
    val searchState = remember { mutableStateOf(TextFieldValue()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue)
    ) {
        Column() {
            TopAppBar(contentColor = Color.Blue) {
                BackIcon(navController = navController)
                SearchView(searchState)
            }

            LazyColumn {
                items(List.listoOfNames) { item ->
                    if (searchState.value.text.isNullOrEmpty()) {

                    } else if (item.lowercase().contains(searchState.value.text) or item.uppercase()
                            .contains(searchState.value.text)
                    ) {
                        SearchItemView(name = item){
                            navigateTo(navController,ScreenDestination.RezervationDetailScreen)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchView(searchState: MutableState<TextFieldValue>) {
    OutlinedTextField(
        value = searchState.value,
        onValueChange = { searchState.value = it },
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
        modifier = Modifier
            .padding(start = 20.dp)
            .background(Color.White, RoundedCornerShape(15.dp))

    )
}

@Composable
fun SearchItemView(name: String,onclick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(listOf(Color.Gray, Color.Gray)),
                shape = RoundedCornerShape(16.dp)
            ) .clickable {
                onclick.invoke()
            }
    ) {
        Text(text = name, color = Color.White, fontSize = 30.sp)
    }
}