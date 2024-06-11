package com.example.tp_2_exo2.ui.screens

import android.annotation.SuppressLint
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.data.ViewModels.ParkingViewModel
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.model.parking.Parking
import com.example.tp_2_exo2.ui.composables.BottomNavigationBar
import com.example.tp_2_exo2.ui.composables.NormalTextComponent
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination
import com.example.tp_2_exo2.ui.theme.Primary
import com.example.tp_2_exo2.ui.theme.Purple80
import com.example.tp_2_exo2.ui.theme.PurpleGrey40
import com.example.tp_2_exo2.ui.theme.PurpleGrey80
import com.example.tp_2_exo2.ui.theme.Secondary
import com.example.tp_2_exo2.ui.theme.TextColor
import com.example.tp_2_exo2.ui.theme.poppinsFontFamily
import com.example.tp_2_exo2.ui.theme.purpleGrey200
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParkingsListScreen(
    parkingViewModel: ParkingViewModel,
    navController: NavHostController
) {
    val allParkingsResponse by parkingViewModel.allParkingsResponse.observeAsState()
    LaunchedEffect(Unit) {
        parkingViewModel.getAllParkings()
    }
    var parkingsList: List<ParkingData>? = allParkingsResponse?.body()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
            )
        }
    ) {
        if(parkingsList == null){
            //loading indicator
            Text("Loading...")
        }else{
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .background(
                        Color.White
                    )
                    .padding(0.dp, 12.dp, 0.dp, 40.dp)
                    .fillMaxWidth()
            ) {
                items(parkingsList!!) {parking->
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(PurpleGrey40)
                            .height(175.dp)
                            .width(375.dp)
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(
                                    "ParkingDetailsScreen/${parking.id}"
                                )
                            },
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Image(
                            painter = painterResource(id = com.example.tp_2_exo2.R.drawable.pic5),
                            contentDescription = "photo de parking",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(150.dp)
                                .width(200.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            Text(
                                text = parking.name,
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
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = parking.wilaya,
                                color = purpleGrey200,
                                modifier = Modifier.padding(3.dp),

                                )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = parking.address,
                                color = purpleGrey200,
                                modifier = Modifier.padding(3.dp),

                                )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}
