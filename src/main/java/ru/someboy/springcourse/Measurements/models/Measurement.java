package ru.someboy.springcourse.Measurements.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author SomeBoy on 12.05.2023
 * @project Measurements
 */
@Entity
@Table(name = "Measurement")
@Getter
@Setter
@NoArgsConstructor
public class Measurement {
    @Id
    @Column(name = "measurement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int measurementId;

    @Column(name = "value")
//    @Size(min = -100, max = 100, message = "Value should be between -100 and 100")
//    @NotEmpty(message = "Value should be empty")
    private double value;

    @Column(name = "raining")
//    @NotEmpty(message = "Raining should be empty")
    private boolean raining;

    @Column(name = "measured_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime measuredAt;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    private Sensor sensor;

    public Measurement(double value, boolean raining) {
        this.value = value;
        this.raining = raining;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "measurementId=" + measurementId +
                ", value=" + value +
                ", raining=" + raining +
                ", measuredAt=" + measuredAt +
                ", sensor=" + sensor +
                '}';
    }
}
