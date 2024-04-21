package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxComponent(
    textValue : String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        val isChecked = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {
                isChecked.value = !isChecked.value
            }
        )

        ClickableTextComponent(textValue = textValue)
    }
}