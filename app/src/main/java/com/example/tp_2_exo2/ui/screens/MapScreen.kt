package com.example.tp_2_exo2.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.data.ViewModels.ParkingViewModel
import com.example.tp_2_exo2.data.model.ParkingData
import com.example.tp_2_exo2.data.utils.splitLatLong
import com.example.tp_2_exo2.ui.composables.BottomNavigationBar
import com.example.tp_2_exo2.ui.navigation.routes.ParkingDestination

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState




@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapScreen(
    parkingViewModel: ParkingViewModel,
    navController: NavHostController
) {
    val allParkingsResponse by parkingViewModel.allParkingsResponse.observeAsState()
    LaunchedEffect(Unit) {
        parkingViewModel.getAllParkings()
    }
    var parkingsList: List<ParkingData>? = allParkingsResponse?.body()

    val atasehir = LatLng(36.72216186302822, 3.107045212485053)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(atasehir, 10f)
    }
    var uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.HYBRID))
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
            )
        }
    ) {
        if(parkingsList == null){
            Text("Loading...")
        }else{
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = properties,
                uiSettings = uiSettings
            ){
                parkingsList!!.forEach { items ->
                    //split lat and long which are separated by comma
                    val (lat,long) = splitLatLong(items.localization)
                    Marker(
                        state = MarkerState(position = LatLng(lat, long)),
                        title = items.name,
                        snippet = items.address,
                        draggable = false,
                    )
                }
            }
        }
    }
}


