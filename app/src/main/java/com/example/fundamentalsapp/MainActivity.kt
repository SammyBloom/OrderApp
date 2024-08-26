package com.example.fundamentalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fundamentalsapp.ui.theme.FundamentalsAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Upperpane()
            AppScreen()
        }
    }
}

@Composable
fun AppScreen() {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    ItemOrder(count, { count++ }, { count-- })
}

@Composable
fun ItemOrder(count: Int, onIncreament: () -> Unit, onDecreament: () -> Unit) {

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Amala and Gbegiri",
            fontSize = 30.sp)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(onClick = { onDecreament() }) {
                Text(
                    text = "-",
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "$count",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(7.dp)
            )
            Button(onClick = { onIncreament() }) {
                Text(
                    text = "+",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemOrderPreview() {
    FundamentalsAppTheme {
        var count by rememberSaveable {
            mutableStateOf(0)
        }
        ItemOrder(count, { count++ }, { count-- })
    }
}