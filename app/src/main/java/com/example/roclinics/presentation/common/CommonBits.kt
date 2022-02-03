package com.example.roclinics.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.roclinics.presentation.AppViewModel
import com.example.roclinics.presentation.navigation.ScreenDestination
import com.example.roclinics.ui.theme.montserrat_light


fun navigateTo(navController: NavController, screenDestination: ScreenDestination) {
    navController.navigate(screenDestination.route) {
        popUpTo(screenDestination.route)
        launchSingleTop = true
    }
}

@Composable
fun CustomDialog(
    openDialog: MutableState<Boolean>,
    textState: MutableState<String>,
    listOfItems: List<String>,
    onDismiss: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Dialog(onDismissRequest = { onDismiss.invoke() }) {
            Box(
                modifier = Modifier
                    .size(height = 600.dp, width = 350.dp)
                    .background(AppColors.Blue)
            ) {
                LazyColumn {
                    items(listOfItems) { item ->
                        Text(
                            text = item,
                            fontSize = 22.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontFamily = montserrat_light,
                            modifier = Modifier
                                .padding(14.dp)
                                .padding(start = 7.dp)
                                .clickable {
                                    textState.value = item
                                    openDialog.value = false
                                })
                    }
                }
            }

        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable() () -> Unit,
    modifier: Modifier = Modifier
        .padding(end = 23.dp, bottom = 15.dp, start = 20.dp)
        .fillMaxWidth()
        .clickable { onClick.invoke() },
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        disabledTextColor = Color.White
    ),
    enabled: Boolean = false,
    onClick: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        modifier = modifier,
        colors = colors,
        enabled = enabled
    )
}



@Composable
fun CheckSignedIn(navController: NavController,viewModel: AppViewModel){
    val signedIn = viewModel.signedIn.value
    val completeInformation = viewModel.completeInformation.value
    if(signedIn == true){
        navigateTo(navController,ScreenDestination.UserScreen)
        }
    }



//TODO
// Check information for introduction screen
