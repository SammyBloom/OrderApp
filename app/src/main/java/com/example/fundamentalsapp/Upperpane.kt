package com.example.fundamentalsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fundamentalsapp.ui.theme.FundamentalsAppTheme

class Upperpane : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FundamentalsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RestaurantDetails(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantDetails(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF495E57))
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.big_bite),
            fontSize = 32.sp,
            color = Color(0xFFF4CE14)
        )
        Text(
            text = stringResource(id = R.string.location),
            fontSize = 24.sp,
            color = Color(0xFFFFFFFF)
        )
        
        Row() {
            Text(
                text = stringResource(id = R.string.description),
                Modifier.width(200.dp)
                    .padding(top = 20.dp, bottom = 20.dp),
                color = Color.White,
                fontSize = 21.sp
            )
            Image(
                painter = painterResource(id = R.drawable.art),
                contentDescription = stringResource(id = R.string.description),
                Modifier
                    .height(200.dp)
                    .clip(AbsoluteRoundedCornerShape(20.dp))
            )
        }
        Button(
            onClick = { Toast.makeText(context, "Order Successful", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE13))
        ) {
            Text(text = stringResource(id = R.string.order))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RestaurantDetailsPreview(){
    FundamentalsAppTheme {
        RestaurantDetails()
    }
}