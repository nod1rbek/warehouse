package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    // CREAT
    public Result addWarehouse(Warehouse warehouse) {
        boolean exists = warehouseRepository.existsByName(warehouse.getName());
        if (exists)
            return new Result("ERROR! This warehouse already added", false);
        Warehouse addedWarehouse = new Warehouse(warehouse.getName(), warehouse.isActive());
        warehouseRepository.save(addedWarehouse);
        return new Result("Warehouse added", true);
    }

    // READ
    public List<Warehouse> getAllWarehouse() {
        return warehouseRepository.findAll();
    }

    // ReadById
    public Warehouse getWarehouseById(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        return optionalWarehouse.orElseGet(Warehouse::new);
    }

    // UPDATE
    public Result editWarehouse(Integer id, Warehouse warehouse) {
        boolean exists = warehouseRepository.existsByName(warehouse.getName());
        if (exists)
            return new Result("ERROR! This warehouse not found", false);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            Warehouse editedWarehouse = optionalWarehouse.get();
            editedWarehouse.setName(warehouse.getName());
            editedWarehouse.setActive(warehouse.isActive());

            warehouseRepository.save(editedWarehouse);
            return new Result("Warehouse edited", true);
        }
        return new Result("ERROR! This warehouse not found", false);
    }

    // DELETE
    public Result deleteWarehouse(Integer id) {
        try {
            warehouseRepository.deleteById(id);
            return new Result("Warehouse deleted", true);
        } catch (Exception e) {
            return new Result("This warehouse not found", false);
        }
    }
}
