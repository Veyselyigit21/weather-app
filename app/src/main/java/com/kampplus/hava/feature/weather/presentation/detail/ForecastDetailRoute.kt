package com.kampplus.hava.feature.weather.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ForecastDetailRoute(onBack: () -> Unit, modifier: Modifier = Modifier, viewModel: ForecastDetailViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ForecastDetailScreen(uiState = uiState, onBack = onBack, modifier = modifier)
}
