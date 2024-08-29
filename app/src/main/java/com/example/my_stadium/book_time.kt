package com.example.my_stadium

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_stadium.ui.theme.CustomColor
import java.time.LocalDate



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FieldBookingScreen(navController: NavController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var checkInTime by remember { mutableStateOf("") }
    var checkOutTime by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp).background(Color.White)
        ,

        horizontalAlignment = Alignment.CenterHorizontally


    ) {

        Text("Field Booking", style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.height(10.dp))
        DatePicker(selectedDate) { date ->
            selectedDate = date
        }
        Image(painter = painterResource(id = R.drawable.date) ,contentDescription = "date image",
            modifier = Modifier.size(500.dp) )

        TimePicker(label = "Check in", selectedTime = checkInTime) { time ->
            checkInTime = time
        }
        Spacer(modifier = Modifier.height(20.dp))
        TimePicker(label = "Check out", selectedTime = checkOutTime) { time ->
            checkOutTime = time
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { /* Handle booking logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(13.dp),
            colors = ButtonDefaults.buttonColors(containerColor = CustomColor),

        ) {
            Text("Book Now", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun DatePicker(selectedDate: LocalDate, onDateChange: (LocalDate) -> Unit) {
    // Placeholder for a date picker UI. Replace with actual DatePicker implementation
    Text(text = "Selected Date: ${selectedDate.toString()}")
}

@Composable
fun TimePicker(label: String, selectedTime: String, onTimeChange: (String) -> Unit) {
    var time by remember { mutableStateOf(selectedTime) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.LightGray)
            .padding(10.dp),

        ) {
        BasicTextField(
            value = time,
            onValueChange = {
                time = it
                onTimeChange(it)
            },
            textStyle = TextStyle(fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(label, color = Color.Black)
                    innerTextField()
                }
            }
        )
    }
}
