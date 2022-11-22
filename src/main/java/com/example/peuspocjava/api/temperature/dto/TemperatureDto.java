package com.example.peuspocjava.api.temperature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@ToString
public class TemperatureDto {
    Long id;
    Float value;
    ZonedDateTime timestamp;
}
