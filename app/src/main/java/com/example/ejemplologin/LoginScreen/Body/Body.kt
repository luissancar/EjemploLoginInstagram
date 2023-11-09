package com.example.ejemplologin.LoginScreen.Body

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplologin.R


@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        ImageLogo()
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) { email = it }
        Spacer(modifier = Modifier.size(16.dp))
        Password(password) { password = it }
        Spacer(modifier = Modifier.size(16.dp))
        ForgotPassword(Modifier.align(Alignment.End))

    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        trailingIcon = {
            Icon(
                painter = painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off),
                contentDescription = "View"
            )
        },
        visualTransformation = PasswordVisualTransformation(),

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChanged(it) })
}


@Composable
fun ImageLogo() {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "logo")
}
