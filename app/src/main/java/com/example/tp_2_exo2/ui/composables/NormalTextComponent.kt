package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.TextColor
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun NormalTextComponent(
    textValue : String,
    textSize : Int,
    textAlign: TextAlign
) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = textSize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = poppinsFontFamily,
        ),
        color = TextColor,
        textAlign = textAlign
    )
}