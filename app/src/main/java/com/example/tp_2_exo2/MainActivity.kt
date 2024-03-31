package com.example.tp_2_exo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp_2_exo2.ui.theme.TP_2_EXO2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP_2_EXO2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var parkingsList = listOf<Parking>(
                        Parking(0,"Parking1", "50", "8 AM - 6 PM", "123 Main St", "Cityville", R.drawable.pic1, "This is a description for Parking1."),
                        Parking(1,"Parking2", "75", "9 AM - 7 PM", "456 Oak St", "Townsville", R.drawable.pic2, "This is a description for Parking2."),
                        Parking(2,"Parking3", "100", "24/7", "789 Pine St", "Metropolis", R.drawable.pic3, "This is a description for Parking3."),
                        Parking(3,"Parking4", "30", "7 AM - 5 PM", "101 Elm St", "Villagetown", R.drawable.pic4, "This is a description for Parking4."),
                        Parking(4,"Parking5", "80", "10 AM - 8 PM", "202 Maple St", "Suburbia", R.drawable.pic5, "This is a description for Parking5.")
                    )
                    var navController = rememberNavController()
                    ParkingNavigation(parkingsList, navController)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP_2_EXO2Theme {

    }
}