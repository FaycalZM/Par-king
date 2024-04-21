package com.example.tp_2_exo2.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tp_2_exo2.ui.theme.Primary
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily

@Composable
fun ClickableLoginTextComponent(
    initialText: String,
    clickableText: String,
    homeNavController: NavHostController
) {


    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = clickableText, annotation = clickableText)
            append(clickableText)
        }
    }

    ClickableText(
        text = annotatedString,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontFamily = poppinsFontFamily,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.tag}}")
                    if (span.tag == "Register") {
                        // navigate to the SignUp screen
                        homeNavController.navigate("sign_up")
                    } else {
                        // navigate to the SignIn screen
                        homeNavController.navigate("sign_in")
                    }
                }
        }
    )
}