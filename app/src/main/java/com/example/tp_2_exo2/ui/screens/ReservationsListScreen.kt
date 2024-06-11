package com.example.tp_2_exo2.ui.screens


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.ReservationData
import com.example.tp_2_exo2.ui.composables.BottomNavigationBar
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination
import com.example.tp_2_exo2.ui.theme.PurpleGrey40
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily
import com.example.tp_2_exo2.ui.theme.purpleGrey200

@Composable
fun ReservationsListPrev(){
    val navController = rememberNavController()
    ReservationsListScreen(com.example.tp_2_exo2.data.utils.reservationsList,com.example.tp_2_exo2.data.utils.parkingsList,navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReservationsListScreen(
    reservationList: List<ReservationData>,
    parkingsList : List<ParkingData>,
    navController: NavHostController
) {
    var selectedReservation by remember { mutableStateOf<ReservationData?>(null) }
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
            )
        }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .background(
                    Color.White
                )
                .padding(4.dp, 12.dp, 4.dp, 80.dp)
        ) {
            items(reservationList) {reservation ->
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(PurpleGrey40)
                        .height(200.dp)
                        .width(375.dp)
                        .padding(10.dp)
                        .clickable {
                            selectedReservation = reservation
                        },
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = painterResource(id = com.example.tp_2_exo2.R.drawable.qr_base),
                        contentDescription = "photo de parking",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Text(
                            //get the parking name from the reservation by id
                            text = parkingsList.find { it.id == reservation.parkingId }?.name ?: "Parking Name",
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 30.dp),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                fontFamily = poppinsFontFamily,
                            ),
                            color = purpleGrey200,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = reservation.date,
                            color = purpleGrey200,
                            modifier = Modifier.padding(3.dp),
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(){
                            Text(
                                text = reservation.outTime,
                                color = purpleGrey200,
                                modifier = Modifier.padding(3.dp),
                            )
                            Text(
                                text = "to",
                                color = purpleGrey200,
                                modifier = Modifier.padding(3.dp),
                            )
                            Text(
                                text = reservation.outTime,
                                color = purpleGrey200,
                                modifier = Modifier.padding(3.dp),
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
    selectedReservation?.let { reservation ->
        AlertDialog(
            onDismissRequest = { selectedReservation = null },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = com.example.tp_2_exo2.R.drawable.qr_base),
                        contentDescription = "QR Code",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                }
            },
            confirmButton = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = { selectedReservation = null }
                    ) {
                        Text("OK")
                    }
                }
            }
        )
    }

}

@Preview
@Composable
fun ReservationsListScreenPreview() {
    ReservationsListPrev()
}