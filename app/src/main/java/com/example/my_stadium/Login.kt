package com.example.my_stadium

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_stadium.constant.Route
import com.example.my_stadium.ui.theme.CustomColor
import com.example.todoapp.componets.DefaultButton

import componets.TextButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController
) {
    val context = LocalContext.current
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
        Image(painter = painterResource(id = R.drawable.login) ,contentDescription = "Login image",
        modifier = Modifier.size(200.dp) )
        Text(text = "Soccerfy", fontSize = 28.sp, fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email,onValueChange ={
                                                       email = it
        }, label = { Text("Email")})


        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password,onValueChange ={

                                                          password = it
        }, label = { Text("Password")},
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
//                navController.navigate(Route.HomeScreen)

                when {
                    email.isEmpty() -> {
                        Toast.makeText(context, "Username cannot be empty", Toast.LENGTH_SHORT).show()
                    }
                    password.length < 8 -> {
                        Toast.makeText(context, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(Route.HomeScreen )
                        // Proceed with login logic
                        }
                        }
            },

            modifier = Modifier
                .width(280.dp)
                .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = CustomColor),
            elevation = ButtonDefaults.buttonElevation(0.dp),

            ){
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }


        Spacer(modifier = Modifier.height(38.dp))
        Row {
            Text(text = "Have not an account?", Modifier.clickable { navController.navigate(Route.SignUp) })
            TextButton(text = " Sign Up",


                ) {
                navController.navigate(Route.Login)
            }
        }
    }
}


