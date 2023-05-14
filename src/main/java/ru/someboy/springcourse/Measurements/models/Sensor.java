package ru.someboy.springcourse.Measurements.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author SomeBoy on 12.05.2023
 * @project Measurements
 */
@Entity
@Table(name = "Sensor")
@Getter
@Setter
@NoArgsConstructor
public class Sensor {
    @Id
    @Column(name = "sensor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    @Column(name = "name")
    @NotEmpty(message = "Name should be empty")
    private String name;

    @OneToMany(mappedBy = "sensor")
    private List<Measurement> measurements;

    public Sensor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorId=" + sensorId +
                ", name='" + name + '\'' +
                ", measurements=" + measurements +
                '}';
    }
}
