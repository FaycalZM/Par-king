package com.example.tp_2_exo2.ui.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParkingsListComposable(parkingsList: List<ParkingData>, navController : NavHostController){

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .background(
                    Color.White
                )
                .padding(4.dp, 12.dp,4.dp,80.dp)
        ) {

            items(parkingsList) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.Gray)
                        .height(175.dp)
                        .width(375.dp)
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(
                                ParkingDestination.ParkingDetails.createRoute(
                                    it.id
                                )
                            )
                        },
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = painterResource(id = it.photo),
                        contentDescription = "photo de parking",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(150.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
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

    }
}