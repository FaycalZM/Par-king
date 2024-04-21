package com.example.tp_2_exo2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.data.model.SignInState
import com.example.tp_2_exo2.ui.composables.ButtonComponent
import com.example.tp_2_exo2.ui.composables.ClickableLoginTextComponent
import com.example.tp_2_exo2.ui.composables.DividerComponent
import com.example.tp_2_exo2.ui.composables.HeadingTextComponent
import com.example.tp_2_exo2.ui.composables.InputField
import com.example.tp_2_exo2.ui.composables.NormalTextComponent
import com.example.tp_2_exo2.ui.composables.PasswordInputField
import com.example.tp_2_exo2.ui.composables.SignInIconBtn
import com.example.tp_2_exo2.ui.theme.White

@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(White)
        ) {
            NormalTextComponent(textValue = stringResource(id = R.string.hello_header), 24, TextAlign.Center)
            HeadingTextComponent(textValue = stringResource(id = R.string.signin_heading))
            Spacer(modifier = Modifier.height(30.dp))

            InputField(
                label = "Email",
                painterResource = painterResource(id = R.drawable.email),
                contentDescription = "email"
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordInputField(
                label = "Password",
                painterResource = painterResource(id = R.drawable.password),
                contentDescription = "password"
            )


            Spacer(modifier = Modifier.padding(0.dp,12.dp))

            ButtonComponent(textValue = "Login")

            DividerComponent()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SignInIconBtn(
                    textValue = "Sign in with Google",
                    onSignInClick = onSignInClick
                )
            }
            Spacer(modifier = Modifier.padding(0.dp,8.dp))
            ClickableLoginTextComponent(
                initialText = "Don't have an account yet? ",
                clickableText = "Register"
            )
        }
    }
}


