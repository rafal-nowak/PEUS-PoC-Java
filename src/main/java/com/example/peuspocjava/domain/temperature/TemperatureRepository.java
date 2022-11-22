package com.example.peuspocjava.domain.temperature;

import com.example.peuspocjava.domain.temperature.model.PageTemperature;
import com.example.peuspocjava.domain.temperature.model.Temperature;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TemperatureRepository {
    Temperature save(Temperature temperature);
    void update(Temperature temperature);
    void remove(Long id);
    Optional<Temperature> findById(Long id);
    PageTemperature findAll(Pageable pageable);
}
