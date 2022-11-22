package com.example.peuspocjava.external.measurement.temperature;

import com.example.peuspocjava.domain.temperature.TemperatureMeasurement;
import com.example.peuspocjava.domain.temperature.model.Temperature;

import java.time.ZonedDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class FakeTemperatureMeasurementAdapter implements TemperatureMeasurement {
    @Override
    public Temperature measureValue() {
        var fakeTemperature = new Temperature(
                0L,
                generateRandomFloat(20.0f, 40.0f),
                ZonedDateTime.now()
                );
        return fakeTemperature;
    }

    public static Float generateRandomFloat(Float min, Float max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");
        float result = ThreadLocalRandom.current().nextFloat() * (max - min) + min;
        if (result >= max) // correct for rounding
            result = Float.intBitsToFloat(Float.floatToIntBits(max) - 1);
        return result;
    }
}
