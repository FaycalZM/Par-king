package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.InputBgColor
import com.example.tp_2_exo2.ui.theme.Primary
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun PasswordInputField(
    label: String,
    painterResource: Painter,
    contentDescription: String,
    passwordState: MutableState<String> = remember {
        mutableStateOf("")
    }
) {
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }

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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = passwordState.value,
        onValueChange = {
            passwordState.value = it
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = contentDescription)
        },
        trailingIcon = {
            val iconImage = if (isPasswordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (isPasswordVisible.value) {
                "Hide Password"
            } else {
                "Show Password"
            }

            IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}