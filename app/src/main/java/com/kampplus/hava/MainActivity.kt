package com.kampplus.hava

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kampplus.hava.core.ui.theme.HavaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HavaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        WeatherCard(cityName = "İstanbul", condition = "Parçalı Bulutlu, 22°C")
        Spacer(modifier = Modifier.height(16.dp))
        WeatherCard(cityName = "Ankara", condition = "Güneşli, 26°C")
    }
}

@Composable
fun WeatherCard(cityName: String, condition: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = cityName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = condition)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherCardPreview() {
    HavaTheme {
        WeatherCard("İzmir", "Açık, 30°C")
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherCardLongTextPreview() {
    HavaTheme {
        WeatherCard(
            cityName = "Kahramanmaraş",
            condition = "Şiddetli sağanak yağışlı ve rüzgarlı, yer yer fırtına bekleniyor. Lütfen dikkatli olun."
        )
    }
}
