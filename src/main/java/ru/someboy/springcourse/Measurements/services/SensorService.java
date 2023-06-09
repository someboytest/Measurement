package ru.someboy.springcourse.Measurements.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.someboy.springcourse.Measurements.models.Sensor;
import ru.someboy.springcourse.Measurements.repositories.SensorRepository;

import java.util.Optional;

/**
 * @author SomeBoy on 13.05.2023
 * @project Measurements
 */
@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor findOne(int id) {
        Optional<Sensor> foundSensor = sensorRepository.findById(id);
        return foundSensor.orElse(null);
    }
    @Transactional
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
