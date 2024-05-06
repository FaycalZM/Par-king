package com.example.tp_2_exo2.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp_2_exo2.data.model.ParkingData

@Composable
fun ParkingDetails(parking: ParkingData){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = parking.photo),
            contentDescription = "parking_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .width(400.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
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