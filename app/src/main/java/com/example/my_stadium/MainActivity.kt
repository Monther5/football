package com.example.my_stadium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


import com.example.my_stadium.LoginScreen
import com.example.my_stadium.ui.theme.My_stadiumTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
//        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]


        setContent {
            My_stadiumTheme {

                  LoginScreen()



                }


            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_stadiumTheme {
//        LoginScreen()


    }
    }
