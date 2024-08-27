package com.example.my_stadium

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Button(onClick: () -> Unit, modifier: Modifier, colors: Any, content: @Composable () -> Unit) {

}

@Composable
fun HugoChavezStadium() {

        Image(
            painter = painterResource(id = R.drawable.stadium),
            contentDescription = "Stadium Image",
            modifier = Modifier.size(2000.dp) )





        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hugo Chávez Football Stadium",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,

                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Banina,Benghazi",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Capacity: 10,550 people",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pitch dimensions: 105m x 68m",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "50 LYD/Hour",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle book now click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text(
                    text = "Book Now",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
