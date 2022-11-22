package com.example.peuspocjava.api.temperature.mapper;

import com.example.peuspocjava.api.temperature.dto.TemperatureDto;
import com.example.peuspocjava.domain.temperature.model.Temperature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemperatureDtoMapper {
    TemperatureDto toDto(Temperature domain);

    Temperature toDomain(TemperatureDto dto);
}
