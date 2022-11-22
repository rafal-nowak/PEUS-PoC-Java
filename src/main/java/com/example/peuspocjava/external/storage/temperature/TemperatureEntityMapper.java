package com.example.peuspocjava.external.storage.temperature;

import com.example.peuspocjava.domain.temperature.model.Temperature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemperatureEntityMapper {
    TemperatureEntity toEntity(Temperature domain);

    Temperature toDomain(TemperatureEntity entity);
}
