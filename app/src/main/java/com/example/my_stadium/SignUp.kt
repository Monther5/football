package com.example.my_stadium

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_stadium.R
import com.example.todoapp.componets.DefaultButton
import com.example.todoapp.constant.Route
import componets.TextButton

import java.lang.Exception


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Text(text = "create an account", fontSize = 28.sp, fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email,onValueChange ={
            email = it
        }, label = { Text("User Name")})


        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email,onValueChange ={
            email = it
        }, label = { Text(" phone")})


        OutlinedTextField(value = email,onValueChange ={

            email = it
        }, label = { Text("Email")},
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password,onValueChange ={

            password = it
        }, label = { Text("Password")},
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(36.dp))

        DefaultButton(buttonText = "Sign up", onClick = {})


        Spacer(modifier = Modifier.height(38.dp))
        Row {
            Text(text = "have an account", Modifier.clickable {  })
            TextButton(text = "  Login") {}

        }









    }


}


