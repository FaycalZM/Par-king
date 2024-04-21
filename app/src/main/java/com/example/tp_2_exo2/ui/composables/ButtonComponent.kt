package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.Primary
import com.example.tp_2_exo2.ui.theme.Secondary
import com.example.tp_2_exo2.ui.theme.Shapes
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun ButtonComponent(textValue: String){
    ElevatedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(50.dp))
            .fillMaxWidth()
            .heightIn(48.dp)
        ,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = textValue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily
            )
        }
    }
}