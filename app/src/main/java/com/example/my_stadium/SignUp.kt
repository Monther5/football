package com.example.my_stadium

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_stadium.constant.Route
import com.example.my_stadium.ui.theme.CustomColor
import com.example.todoapp.componets.DefaultButton

import componets.TextButton
import org.w3c.dom.Text


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
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

        Spacer(modifier = Modifier.height(16.dp))
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



        Button(
            onClick = {
                navController.navigate(Route.HomeScreen)
        },
            modifier = Modifier
                .width(280.dp)
                .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = CustomColor),
            elevation = ButtonDefaults.buttonElevation(0.dp),

        ){
            Text(
                text = "Sign up",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }


        Spacer(modifier = Modifier.height(38.dp))
        Row {
            Text(text = "have an account",
            )
            Text(text = "  Login",

                Modifier.clickable {
                navController.navigate(Route.Login)
            })

        }
    }
}


