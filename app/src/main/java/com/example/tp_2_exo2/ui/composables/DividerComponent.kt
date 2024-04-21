package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.Gray
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily


@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,32.dp,0.dp,12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Gray,
            thickness = 1.dp
        )

        Text(
            text = "or",
            modifier = Modifier.padding(4.dp,0.dp),
            fontSize = 16.sp,
            fontFamily = poppinsFontFamily
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Gray,
            thickness = 1.dp
        )
    }
}