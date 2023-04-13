package com.example.collectit.screens

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.test.espresso.base.Default
import com.example.collectit.navigation.NavRoute
import androidx.compose.material3.Text as Text

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString("Sign up here"),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = { },
                style = TextStyle(
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline,
                )
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = email,
                placeholder = { Text(text = "user@email.com") },
                label = { Text(text = "email") },
                onValueChange = onEmailChange,
            )

            OutlinedTextField(
                value = password,
                placeholder = { Text(text = "password") },
                label = { Text(text = "password") },
                onValueChange = onPasswordChange,
            )
            Button(onClick = {
                if (email.isBlank() == false && password.isBlank() == false) {
                    onLoginClick(email)
                    focusManager.clearFocus()
                } else {
                    Toast.makeText(
                        context,
                        "Please enter email and password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text1("Login")
            }
        }
    }
}