package com.example.restapi.data

data class WeatherResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val gust_kph: Double,
    val humidity: Int,
    val last_updated: String,
    val last_updated_epoch: Int,
    val precip_mm: Double,
    val temp_c: Double,
    val uv: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val wind_kph: Double
)

data class Forecast(
    val forecastday: List<Forecastday>
)

data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
)

data class Condition(
    val icon: String,
    val text: String
)

data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
)

data class Astro(
    val moon_illumination: String,
    val moon_phase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)

data class Day(
    val avghumidity: Double,
    val avgtemp_c: Double,
    val avgvis_km: Double,
    val condition: Condition,
    val daily_chance_of_rain: Int,
    val daily_chance_of_snow: Int,
    val daily_will_it_rain: Int,
    val daily_will_it_snow: Int,
    val maxtemp_c: Double,
    val maxwind_kph: Double,
    val mintemp_c: Double,
    val totalprecip_mm: Double
)

data class Hour(
    val chance_of_rain: Int,
    val cloud: Int,
    val condition: Condition,
    val dewpoint_c: Double,
    val feelslike_c: Double,
    val gust_kph: Double,
    val heatindex_c: Double,
    val humidity: Int,
    val precip_mm: Double,
    val pressure_mb: Double,
    val temp_c: Double,
    val time: String,
    val time_epoch: Int,
    val vis_km: Double,
    val will_it_rain: Int,
    val will_it_snow: Int,
    val wind_degree: Int,
    val wind_dir: String,
    val wind_kph: Double,
    val windchill_c: Double
)