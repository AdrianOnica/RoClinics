package com.example.roclinics.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.roclinics.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
val openSans = FontFamily(
    Font(R.font.open_sans,FontWeight.Normal)
)
val montserrat_thinItalic = FontFamily(
    Font(R.font.montserrat_thinitalic)
)
val montserrat_extralightItalic = FontFamily(
    Font(R.font.montserrat_extralightitalic)
)
val montserrat_light = FontFamily(
    Font(R.font.montserrat_light)
)
val cabin_regular = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Light)
)
