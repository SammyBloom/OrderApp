package com.example.fundamentalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fundamentalsapp.ui.theme.FundamentalsAppTheme

class LowerPane : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FundamentalsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeeklySpecialCard(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                    MenuDish()
                }
            }
        }
    }
}

@Composable
fun WeeklySpecialCard(modifier: Modifier = Modifier) {
    Card(
        Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Weekly Special",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
            )
    }
}

@Composable
fun MenuDish() {
    Card() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = "Amala and Gbegiri",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "The famous traditional food of the Yoruba people of Nigeria.",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = "N8,000",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = R.drawable.amala_gbegiri),
                contentDescription = "",
                Modifier
                    .height(100.dp)
                    .clip(AbsoluteRoundedCornerShape(5.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeeklySpecialCardPreview(){
    FundamentalsAppTheme {
        WeeklySpecialCard()
    }
}

@Preview(showBackground = true)
@Composable
fun MenuDishPreview(){
    FundamentalsAppTheme {
        MenuDish()
    }
}
