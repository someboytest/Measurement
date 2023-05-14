package ru.someboy.springcourse.Measurements.dto;

import lombok.Getter;
import lombok.Setter;
import ru.someboy.springcourse.Measurements.models.Sensor;

/**
 * @author SomeBoy on 13.05.2023
 * @project Measurements
 */
@Getter
@Setter
public class MeasurementDTO {
//    @Size(min = -100, max = 100, message = "Value should be between -100 and 100")
//    @NotEmpty(message = "Value should be empty")
    private double value;

//    @NotEmpty(message = "Raining should be empty")
    private boolean raining;

    private Sensor sensor;
}
