package org.example.redis.service;

import org.example.redis.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;


@Service
public class WeatherService {
    
    private final WebClient webClient;

    
    private  final String key;
    

    public WeatherService(@Value("${visualcrossing.api.key}")String key,WebClient webClient){
        this.key=key;
        this.webClient=webClient;
    }

    //get the weather by the city's name
    @CachePut(value ="WEATHER_CITY",key = "#city")
    public Mono<WeatherDTO> getWeatherByCity(String city){
        return webClient.get()
                .uri(city+"?key="+key)
                .retrieve()
                .bodyToMono(WeatherDTO.class);
    }

    //get the weather by the lat and lon
    @CachePut(value ="WEATHER_CITY",key = "#lat +#lon")
    public Mono<WeatherDTO> getWeather(Float lat,Float lon) {
        return webClient.get()
                 .uri(lat+","+lon+"?key="+key)
                 .retrieve()
                 .bodyToMono(WeatherDTO.class);   
    }
    
}