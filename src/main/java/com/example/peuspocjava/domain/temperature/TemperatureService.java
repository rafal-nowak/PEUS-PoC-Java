package com.example.peuspocjava.domain.temperature;

import com.example.peuspocjava.domain.temperature.exceptions.TemperatureNotFoundException;
import com.example.peuspocjava.domain.temperature.model.PageTemperature;
import com.example.peuspocjava.domain.temperature.model.Temperature;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class TemperatureService {

    private final TemperatureRepository temperatureRepository;
    private final TemperatureMeasurement temperatureMeasurement;

    public Temperature save(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

    public void update(Temperature temperature) {
        temperatureRepository.update(temperature);
    }

    public void removeById(Long id) {
        temperatureRepository.remove(id);
    }

    public Temperature findById(Long id) {
        return temperatureRepository.findById(id)
                .orElseThrow(TemperatureNotFoundException::new);
    }

    public PageTemperature findAll(Pageable pageable) {
        return temperatureRepository.findAll(pageable);
    }

    public Temperature measureTemperatureAndRecordResult() {
        var actualTemperature = temperatureMeasurement.measureValue();
        var savedTemperature = temperatureRepository.save(actualTemperature);
        return savedTemperature;
    }
}
