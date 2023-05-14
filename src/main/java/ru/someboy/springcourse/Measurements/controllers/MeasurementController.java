package ru.someboy.springcourse.Measurements.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.someboy.springcourse.Measurements.dto.MeasurementDTO;
import ru.someboy.springcourse.Measurements.models.Measurement;
import ru.someboy.springcourse.Measurements.services.MeasurementsService;
import ru.someboy.springcourse.Measurements.services.SensorService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SomeBoy on 13.05.2023
 * @project Measurements
 */
@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementsService measurementsService;
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementsService measurementsService, SensorService sensorService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MeasurementDTO> getMeasurements() {
        measurementsService.findAll().forEach(System.out::println);
        return measurementsService.findAll()
                .stream()
                .map(this::convertToMeasurementDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody MeasurementDTO measurementDTO) {
        measurementsService.save(convertToMeasurement(measurementDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        System.out.println(sensorService.findOne(measurement.getSensor().getSensorId()));
        MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setValue(measurement.getValue());
        measurementDTO.setRaining(measurement.isRaining());
        measurementDTO.setSensor(sensorService.findOne(measurement.getSensor().getSensorId()));
//        System.out.println(measurement.getSensor());
        return measurementDTO;
//        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
