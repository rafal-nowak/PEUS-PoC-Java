package com.example.peuspocjava.api.temperature.dto;

import lombok.Value;

import java.util.List;

@Value
public class PageTemperatureDto {
    List<TemperatureDto> temperatures;
    Integer currentPage;
    Integer totalPages;
    Long totalElements;
}
