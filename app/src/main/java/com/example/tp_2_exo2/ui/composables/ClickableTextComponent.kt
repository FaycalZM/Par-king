package com.example.tp_2_exo2.ui.composables

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.ui.theme.Primary
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun ClickableTextComponent(
    textValue: String
) {
    val initialText = "By continuing you agree to our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsText = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsText, annotation = termsText)
            append(termsText)
        }
    }

    ClickableText(
        text = annotatedString,
        style = TextStyle(
            fontFamily = poppinsFontFamily,
            fontSize = 13.sp
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{$span}")
                }
        }
    )
}