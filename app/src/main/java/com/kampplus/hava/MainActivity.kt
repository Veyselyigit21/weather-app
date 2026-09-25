package com.kampplus.hava

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kampplus.hava.core.ui.theme.HavaTheme
import com.kampplus.hava.feature.weather.presentation.detail.CityDetailScreen
import com.kampplus.hava.feature.weather.presentation.list.CityListRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HavaTheme {
                HavaAppNavigation()
            }
        }
    }
}

@Composable
fun HavaAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list_screen") {
        composable("list_screen") {
            CityListRoute(
                onCityClick = { cityName ->
                    navController.navigate("detail_screen/$cityName")
                }
            )
        }

        composable(
            route = "detail_screen/{cityName}",
            arguments = listOf(navArgument("cityName") { type = NavType.StringType })
        ) { backStackEntry ->
            val clickedCityName = backStackEntry.arguments?.getString("cityName") ?: ""
            
            CityDetailScreen(
                cityName = clickedCityName,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
