package org.example.redis.dto;

import lombok.Data;

@Data
public class DaysDTO {
    private String datetime;
    private double tempmax;
    private double tempmin;
    private double temp;
}
