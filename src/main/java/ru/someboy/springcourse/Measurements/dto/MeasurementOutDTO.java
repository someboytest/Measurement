package ru.someboy.springcourse.Measurements.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author SomeBoy on 14.05.2023
 * @project Measurements
 */
@Getter
@Setter
public class MeasurementOutDTO {
    //    @Size(min = -100, max = 100, message = "Value should be between -100 and 100")
//    @NotEmpty(message = "Value should be empty")
    private double value;

    //    @NotEmpty(message = "Raining should be empty")
    private boolean raining;

    private String sensor;
}
