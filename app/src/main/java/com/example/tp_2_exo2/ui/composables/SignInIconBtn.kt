package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun SignInIconBtn(
    textValue: String,
    onSignInClick: () -> Unit
) {
    IconButton(
        onClick = onSignInClick,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Surface(
            border = BorderStroke(width = 1.dp, color = Color.LightGray),
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.surface,
        ) {
            Row(
                modifier = Modifier.padding(0.dp,8.dp,12.dp,8.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Unspecified
                )
                Text(
                    text = textValue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppinsFontFamily
                )
            }
        }
    }
}