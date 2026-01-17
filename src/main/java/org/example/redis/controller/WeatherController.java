package org.example.redis.controller;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import org.example.redis.dto.WeatherDTO;
import org.example.redis.service.WeatherService;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService service;

    public WeatherController(WeatherService service){
        this.service=service;
    }

    @GetMapping("/{latitude},{longitude}")
    public Mono<WeatherDTO> getWeather(@PathVariable("latitude") float lat, @PathVariable("longitude") float lon){
        return service.getWeather(lat, lon);
    }


    @GetMapping("/{city}")
    public Mono<WeatherDTO> getWeatherByCity(@PathVariable("city") String city){
        return service.getWeatherByCity(city);
    }

}
