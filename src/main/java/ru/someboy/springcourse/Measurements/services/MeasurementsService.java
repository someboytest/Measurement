package ru.someboy.springcourse.Measurements.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.someboy.springcourse.Measurements.models.Measurement;
import ru.someboy.springcourse.Measurements.repositories.MeasurementsRepository;
import ru.someboy.springcourse.Measurements.repositories.SensorRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author SomeBoy on 12.05.2023
 * @project Measurements
 */
@Service
@Transactional(readOnly = true)
public class MeasurementsService {
    private final MeasurementsRepository measurementsRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorRepository sensorRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Measurement> findAll() {
        //TODO вставить вручную строку названия сенсора
        return measurementsRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setSensor(sensorRepository.findByName(measurement.getSensor().getName()).get(0));
        measurement.setMeasuredAt(LocalDateTime.now());
    }
}
