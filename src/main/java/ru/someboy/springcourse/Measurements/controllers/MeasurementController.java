package ru.someboy.springcourse.Measurements.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.someboy.springcourse.Measurements.dto.MeasurementDTO;
import ru.someboy.springcourse.Measurements.dto.MeasurementOutDTO;
import ru.someboy.springcourse.Measurements.models.Measurement;
import ru.someboy.springcourse.Measurements.services.MeasurementsService;

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
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MeasurementOutDTO> getMeasurements() {
        measurementsService.findAll().forEach(System.out::println);
        return measurementsService.findAll()
                .stream()
                .map(this::convertToMeasurementOutDTO)
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

    private MeasurementOutDTO convertToMeasurementOutDTO(Measurement measurement) {
        MeasurementOutDTO measurementOutDTO = new MeasurementOutDTO();
        measurementOutDTO.setValue(measurement.getValue());
        measurementOutDTO.setRaining(measurement.isRaining());
        measurementOutDTO.setSensor(measurement.getSensor().getName());
        System.out.println(measurement.getSensor());
        return measurementOutDTO;
//        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
