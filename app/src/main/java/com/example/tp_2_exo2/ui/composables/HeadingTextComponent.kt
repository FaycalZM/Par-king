package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.TextColor
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun HeadingTextComponent(
    textValue : String
) {
    Text(
        text = textValue,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = poppinsFontFamily
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}