package com.example.my_stadium
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.my_stadium.constant.Route
import com.example.my_stadium.ui.theme.CustomColor
import com.example.my_stadium.ui.theme.CustomColorg


@Composable
fun MainScreen() {
 //   val navController = rememberNavController()
   // Scaffold(
     //   topBar = { TopAppBar() },
       // bottomBar = { BottomNavigationBar(navController) }
   // ) {
 //       Navigation(navController)
    //}
}

@Composable
fun TopAppBar() {
    TopAppBar(

        title = {
            Text(text = "Soccerfy",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = CustomColor

        )
                },

        actions = {
            IconButton(onClick = { /* */ }) {
                Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
            }
        },

        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 8.dp
    )
}

@Composable
fun BottomNavigationBarr(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val items = listOf(
            BottomNavItem(Route.HomeScreen, Icons.Default.Home),
            BottomNavItem("Favarite", Icons.Default.Favorite),
            BottomNavItem(Route.profile, Icons.Default.Person),
            BottomNavItem(Route.Settings, Icons.Default.Settings)
        )

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = false,
                onClick = {
                    navController.navigate(item.name) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "Home") {
        composable("Home") { HomeScreen(nav = navController) }

    }
}

@Composable
fun HomeScreen(nav: NavController) {

    Scaffold(
        bottomBar = @androidx.compose.runtime.Composable { BottomNavigationBar(
            navController = nav
        ) },

    ){p  ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(p)) {
            TopAppBar()
            Spacer(modifier = Modifier.height(66.dp))

            SearchBar()
            Spacer(modifier = Modifier.height(46.dp))

            CategoryBar()
            Spacer(modifier = Modifier.height(36.dp))

            LazyRow() {


                item {

                    StadiumCard(
                        stadiumName = "The Goats Stadium",
                        location = "alhwary, Benghazi",
                        price = "50 LYD/Hour",
                        rating = 3.1f,

                        description = "This is a Libyan football stadium located in Alhadayak.",
                        imageRes = R.drawable.st2,
                        nav
                    )
                }
                item {
                    StadiumCard(
                        stadiumName = "Hugo Chávez Stadium",
                        location = "Hadayak, Benghazi",
                        price = "60 LYD/Hour",
                        rating = 4.1f,

                        description = "This is a Libyan football stadium located in Alhadayak.",
                        imageRes = R.drawable.stadium,
                        nav
                    )
                }
                item {
                    StadiumCard(
                        stadiumName = "St James' Park",
                        location = "Hadayak, Benghazi",
                        price = "70 LYD/Hour",
                        rating = 4.9f,

                        description = "This is a Libyan football stadium located in Alhadayak.",
                        imageRes = R.drawable.st3,
                        nav
                    )
                }
                item {
                    StadiumCard(
                        stadiumName = " Wembley Stadium",
                        location = "Hadayak, Benghazi",
                        price = "80 LYD/Hour",
                        rating = 4.7f,

                        description = "This is a Libyan football stadium located in Alhadayak.",
                        imageRes = R.drawable.st4,
                        nav
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(446.dp))

    }

}




@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = { /* */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text(text = "Search...") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search Icon")
        },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFF1F1F1),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun CategoryBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { /*  */ },
            colors = ButtonDefaults.buttonColors(  CustomColorg),

            shape = RoundedCornerShape(9.dp),
        ) {
            Text(text = "Nearby")
        }
        Button(onClick = { /*  */ },
            colors = ButtonDefaults.buttonColors(  CustomColorg),
            shape = RoundedCornerShape(9.dp),

            ) {
            Text(text = "Most expensive")
        }
        Button(onClick = { /* */ },
            colors = ButtonDefaults.buttonColors(  CustomColorg),
            shape = RoundedCornerShape(9.dp),
        ) {
            Text(text = "Cheapest")
        }
    }

}

@Composable
fun StadiumCard(
    stadiumName: String,
    location: String,
    price: String,
    rating: Float,
    description: String,
    imageRes: Int,
    navController:NavController
) {
    Card(
        modifier = Modifier
            .padding(end = 28.dp, start = 10.dp)
            .height(400.dp)
            .width(310.dp).clickable {
           navController.navigate(Route.StadiumBookingScreen)
                    },
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stadiumName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = location,
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$rating ★", fontWeight = FontWeight.Bold)
                Text(text = price, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}





data class BottomNavItem(val name: String, val icon: ImageVector)
