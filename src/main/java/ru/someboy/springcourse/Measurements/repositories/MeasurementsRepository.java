package ru.someboy.springcourse.Measurements.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.someboy.springcourse.Measurements.models.Measurement;

/**
 * @author SomeBoy on 12.05.2023
 * @project Measurements
 */
@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
}
