package com.example.my_stadium

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController
import com.example.my_stadium.constant.Route
import com.example.my_stadium.ui.theme.CustomColor
import com.example.my_stadium.ui.theme.CustomColorg
import com.example.my_stadium.ui.theme.CustomColorgg

@Composable
fun SoccerfyApp(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(
            navController
        ) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFE5E5E5))
                .verticalScroll(rememberScrollState())
        ) {
            ProfileSection()
            RecentsSection()
        }
    }
}

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "Soccerfy",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
                    color = CustomColor
        )
        Spacer(modifier = Modifier.height(18.dp))
        Icon(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Icon",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ },
                colors = androidx.compose.material.ButtonDefaults.buttonColors(  CustomColorgg),
            ) {
                Text(text = "Edit Profile")
            }
            Button(onClick = { /*TODO*/ },
                colors = androidx.compose.material.ButtonDefaults.buttonColors(  CustomColorgg),

                ) {
                Text(text = "History")
            }
        }
    }
}

@Composable
fun RecentsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        RecentStadiumItem("The Goats Stadium", "Hadayak, Benghazi", R.drawable.stadium) // Replace with your image
        Spacer(modifier = Modifier.height(8.dp))
        RecentStadiumItem("Hugo Chávez Football Stadium", "Banina, Benghazi", R.drawable.st4) // Replace with your image
    }
}

@Composable
fun RecentStadiumItem(title: String, location: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(300.dp)
            .width(330.dp)
            .padding(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = location, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController:NavController
) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            selected = false,
            onClick = { navController.navigate(Route.HomeScreen) }
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") },
            selected = false,
            onClick = { navController.navigate(Route.save) }
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile") },
            selected = true,
            onClick = { navController.navigate(Route.profile) }
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings") },
            selected = false,
            onClick = { /**/ }
        )
    }
}


