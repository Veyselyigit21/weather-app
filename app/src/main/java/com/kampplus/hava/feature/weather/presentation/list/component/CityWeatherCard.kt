package com.kampplus.hava.feature.weather.presentation.list.component
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kampplus.hava.core.ui.component.TemperatureBadge
import com.kampplus.hava.core.ui.text.UiText
import com.kampplus.hava.core.ui.theme.HavaTheme
import com.kampplus.hava.feature.weather.presentation.model.CityWeatherUiModel
import com.kampplus.hava.feature.weather.presentation.model.temperatureColor
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityWeatherCard(
    item: CityWeatherUiModel, 
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TemperatureBadge(text = item.temperatureText, containerColor = temperatureColor(item.temperatureC))
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(item.subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text("${item.conditionEmoji} ${item.conditionLabel.asString()}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
@Preview
@Composable
private fun CityWeatherCardPreview() {
    HavaTheme {
        CityWeatherCard(item = CityWeatherUiModel(1, "Ankara", "Ankara, Türkiye", "21°", 21.0, "☀️", UiText.Dynamic("Açık")), onClick = {})
    }
}
