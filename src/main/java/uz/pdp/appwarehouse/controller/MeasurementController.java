package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        return measurementService.addMeasurementSercise(measurement);
    }

    @GetMapping
    public List<Measurement> getMeasurementController() {
        return measurementService.getMeasurements();
    }

    @GetMapping("/{id}")
    public Measurement getMeasurementById(@PathVariable Integer id) {
        return measurementService.getMeasurementById(id);
    }

    @PutMapping("/{id}")
    public Result editeMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement) {
        return measurementService.editMeasurement(id, measurement);
    }

    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id) {
        return measurementService.deleteMeasurement(id);
    }
}
