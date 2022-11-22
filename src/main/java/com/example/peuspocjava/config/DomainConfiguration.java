package com.example.peuspocjava.config;

import com.example.peuspocjava.domain.temperature.TemperatureMeasurement;
import com.example.peuspocjava.domain.temperature.TemperatureRepository;
import com.example.peuspocjava.domain.temperature.TemperatureService;
import com.example.peuspocjava.external.measurement.temperature.FakeTemperatureMeasurementAdapter;
import com.example.peuspocjava.external.storage.temperature.JpaTemperatureRepository;
import com.example.peuspocjava.external.storage.temperature.TemperatureEntityMapper;
import com.example.peuspocjava.external.storage.temperature.TemperatureStorageAdapter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("domain.properties")
class DomainConfiguration {

    @Bean
    public TemperatureMeasurement temperatureMeasurement() {
        return new FakeTemperatureMeasurementAdapter();
    }

    @Bean
    public TemperatureRepository temperatureRepository(JpaTemperatureRepository jpaTemperatureRepository, TemperatureEntityMapper temperatureEntityMapper) {
        return new TemperatureStorageAdapter(jpaTemperatureRepository, temperatureEntityMapper);
    }

    @Bean
    public TemperatureService temperatureService(TemperatureRepository temperatureRepository, TemperatureMeasurement temperatureMeasurement) {
        return new TemperatureService(temperatureRepository, temperatureMeasurement);
    }
}
