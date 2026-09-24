package com.kampplus.hava.feature.weather.domain.repository

import com.kampplus.hava.core.common.result.AppResult
import com.kampplus.hava.feature.weather.domain.model.CityWeather
import kotlinx.coroutines.flow.Flow

/**
 * Hava verisinin tek giriş noktası. Verinin sabit listeden mi, ağdan mı, cache'ten mi
 * geldiği bu sözleşmenin arkasında kalır.
 */
interface WeatherRepository {
    /** Öne çıkan şehirlerin anlık hava durumu. */
    fun getCityWeathers(): Flow<AppResult<List<CityWeather>>>
}
