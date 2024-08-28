package com.example.my_stadium

import StadiumBookingScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.my_stadium.constant.Route
import com.example.my_stadium.ui.theme.My_stadiumTheme


class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)


        setContent {
            My_stadiumTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.SignUp, builder = {
                    composable(Route.SignUp) {
                        SignUpScreen(navController)
                    }
                    composable(Route.Login) {
                        LoginScreen(navController)
                    }

                    composable(Route.HomeScreen) {
                        HomeScreen(navController)
                    }
                    composable(Route.StadiumBookingScreen) {
                        StadiumBookingScreen(navController)
                    }
                })


            }


        }
    }
}





