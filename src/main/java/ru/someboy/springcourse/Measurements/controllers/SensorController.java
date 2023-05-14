package ru.someboy.springcourse.Measurements.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.someboy.springcourse.Measurements.models.Sensor;
import ru.someboy.springcourse.Measurements.services.SensorService;

/**
 * @author SomeBoy on 13.05.2023
 * @project Measurements
 */
@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody Sensor sensor) {
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
