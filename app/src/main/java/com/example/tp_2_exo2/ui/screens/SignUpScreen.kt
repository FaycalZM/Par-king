package com.example.tp_2_exo2.ui.screens



import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tp_2_exo2.R
import com.example.tp_2_exo2.data.model.auth.AuthViewModel
import com.example.tp_2_exo2.data.utils.createPartFromString
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
import okhttp3.RequestBody

@Composable
fun SignUpScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    val signupResponse by authViewModel.signupResponse.observeAsState()


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

    val onSignUpClick:()-> Unit={
        val map : MutableMap<String,RequestBody> = mutableMapOf()
        val first_name = createPartFromString(firstNameState.value)
        val last_name = createPartFromString(lastNameState.value)
        val email = createPartFromString(emailState.value)
        val password = createPartFromString(passwordState.value)
        map.put("first_name",first_name)
        map.put("last_name",last_name)
        map.put("email",email)
        map.put("password",password)
        authViewModel.signupUser(map)
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
                onBtnClick = onSignUpClick
            )
            AddProgress(authViewModel)
            signupResponse?.let {
                if(!it.isSuccessful){
                    Text("Signup failed: ${authViewModel.error.value}", color = Color.Red)
                }
            }

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

@Composable
fun AddProgress(authViewModel: AuthViewModel) {
    val isLoading = authViewModel.loading.value

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

