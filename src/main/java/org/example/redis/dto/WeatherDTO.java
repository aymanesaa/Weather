package org.example.redis.dto;

import java.util.List;

import lombok.Data;

@Data
public class WeatherDTO{
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String timezone;
    private String address;
    private String description;
    private List<DaysDTO> days;
}