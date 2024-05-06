package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.InputBgColor
import com.example.tp_2_exo2.ui.theme.Primary
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun InputField(
    label: String,
    painterResource: Painter,
    contentDescription: String,
    state: MutableState<String>,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(InputBgColor),
        label = { Text(text = label) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = state.value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = contentDescription)
        }
    )
}