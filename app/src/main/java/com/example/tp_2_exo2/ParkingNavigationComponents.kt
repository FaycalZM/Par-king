package com.example.tp_2_exo2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import com.example.tp_2_exo2.presentation.profile.ProfileScreen
import com.example.tp_2_exo2.presentation.sign_in.UserData

@Composable
fun ParkingsListComposable(parkingsList: List<Parking>,navController : NavHostController){

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly, modifier =  Modifier.background(
        Color.White).padding(4.dp,12.dp) ){

        items(parkingsList){
            Row(modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray)
                .height(175.dp)
                .width(375.dp)
                .padding(10.dp)
                .clickable { navController.navigate(ParkingDestination.ParkingDetails.createRoute(it.id)) },
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                Image(painter = painterResource(id = it.photo), contentDescription = "photo de parking", contentScale = ContentScale.Crop, modifier = Modifier
                    .height(150.dp)
                    .width(200.dp)
                    .clip(RoundedCornerShape(10.dp)))
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = it.nom, color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = it.capacite, color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = it.horaires, color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = it.emplacement, color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = it.commune, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

    Spacer(modifier = Modifier.padding(48.dp))

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate(ParkingDestination.Profile.route)
        }) {
            Text(text = "Show Profile")
        }
    }
}

@Composable
fun ParkingDetails(parking:Parking){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
        Image(painter = painterResource(id = parking.photo), contentDescription = "photo de parking", contentScale = ContentScale.Crop, modifier = Modifier
            .height(300.dp)
            .width(400.dp)
            .clip(RoundedCornerShape(10.dp)))
        Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = parking.nom, fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = parking.horaires)
            Spacer(modifier = Modifier.height(5.dp))
        }
        Text(text = parking.capacite)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = parking.emplacement)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = parking.commune)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = parking.description)
    }
}

@Composable
fun ParkingNavigation(
    parkingsList: List<Parking>,
    userData: UserData?,
    onSignOut : () -> Unit ,
    navController : NavHostController){

    NavHost(navController = navController, startDestination = "parkingsList"){
        composable(ParkingDestination.Profile.route){ ProfileScreen(userData = userData , onSignOut=onSignOut)}
        composable(ParkingDestination.ParkingsList.route){ ParkingsListComposable(parkingsList,navController)}
        composable(ParkingDestination.ParkingDetails.route){
                navBack ->
            val id = navBack.arguments?.getString("ParkingId")?.toInt()
            ParkingDetails(parkingsList[id!!])
        }
    }
}