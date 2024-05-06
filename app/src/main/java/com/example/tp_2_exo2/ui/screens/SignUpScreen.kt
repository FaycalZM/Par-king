package com.example.tp_2_exo2.ui.screens


import android.util.Log
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.data.model.auth.SignInState
import com.example.tp_2_exo2.data.model.user.User
import com.example.tp_2_exo2.data.model.user.UserModel
import com.example.tp_2_exo2.ui.composables.ButtonComponent
import com.example.tp_2_exo2.ui.composables.CheckboxComponent
import com.example.tp_2_exo2.ui.composables.ClickableLoginTextComponent
import com.example.tp_2_exo2.ui.composables.DividerComponent
import com.example.tp_2_exo2.ui.composables.HeadingTextComponent
import com.example.tp_2_exo2.ui.composables.InputField
import com.example.tp_2_exo2.ui.composables.NormalTextComponent
import com.example.tp_2_exo2.ui.composables.PasswordInputField
import com.example.tp_2_exo2.ui.composables.SignInIconBtn
import com.example.tp_2_exo2.ui.theme.White



@Composable
fun SignUpScreen(
    navController: NavHostController,
) {

    val firstNameState = remember {
        mutableStateOf("")
    }
    val lastNameState = remember {
        mutableStateOf("")
    }
    val emailState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
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
            HeadingTextComponent(textValue = stringResource(id = R.string.signup_heading))
            Spacer(modifier = Modifier.height(30.dp))
            InputField(
                label = "First Name",
                painterResource = painterResource(id = R.drawable.profile),
                contentDescription = "first_name",
                state = firstNameState,
                onValueChange = {
                    firstNameState.value = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputField(
                label = "Last Name",
                painterResource = painterResource(id = R.drawable.profile),
                contentDescription = "last_name",
                state = lastNameState,
                onValueChange = {
                    lastNameState.value = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            InputField(
                label = "Email",
                painterResource = painterResource(id = R.drawable.email),
                contentDescription = "email",
                state = emailState,
                onValueChange = {
                    emailState.value = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordInputField(
                label = "Password",
                painterResource = painterResource(id = R.drawable.password),
                contentDescription = "password",
                passwordState = passwordState
            )

            CheckboxComponent(textValue = stringResource(id = R.string.accept_terms_and_conditions))
            Spacer(modifier = Modifier.padding(0.dp,12.dp))

            ButtonComponent(
                textValue = "Register",
            )

            DividerComponent()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SignInIconBtn(textValue = "Sign up with Google")
            }
            Spacer(modifier = Modifier.padding(0.dp,8.dp))
            ClickableLoginTextComponent(
                initialText = "Already have an account? ",
                clickableText = "Login",
                navController = navController
            )
        }
    }
}

