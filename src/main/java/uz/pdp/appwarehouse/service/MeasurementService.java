package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    // CREATE
    public Result addMeasurementSercise(Measurement measurement) {
        boolean exists = measurementRepository.existsByName(measurement.getName());
        if (exists)
            return new Result("ERROR! This measurement already added", false);
        Measurement addedMeasurement = new Measurement(measurement.getName(), measurement.isActive());
        measurementRepository.save(addedMeasurement);
        return new Result("Measurment added", true);
    }

    // READ
    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    // ReadById
    public Measurement getMeasurementById(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        return optionalMeasurement.orElseGet(Measurement::new);
    }

    // UPDATE
    public Result editMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            Measurement editedMEasurement = optionalMeasurement.get();
            editedMEasurement.setName(measurement.getName());
            editedMEasurement.setActive(measurement.isActive());

            measurementRepository.save(editedMEasurement);
            return new Result("This measurement edited", true);
        }
        return new Result("ERORR! This measurement not found", false);
    }

    // DELETE
    public Result deleteMeasurement(Integer id) {
        try {
            measurementRepository.deleteById(id);
            return new Result("This measurement deleted", true);
        } catch (Exception e) {
            return new Result("This measurement not found", false);
        }
    }
}
