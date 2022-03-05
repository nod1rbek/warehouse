package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    // CREAT
    public Result addSupplier(Supplier supplier) {
        boolean exists = supplierRepository.existsByNameAndPhoneNumber(supplier.getName(),supplier.getPhoneNumber());
        if (exists)
            return new Result("ERROR! This supplier already added", false);
        Supplier addedSupplier = new Supplier(supplier.getName(), supplier.isActive(), supplier.getPhoneNumber());
        supplierRepository.save(addedSupplier);
        return new Result("Supplier added", true);
    }

    // READ
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    // ReadById
    public Supplier getSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        return optionalSupplier.orElseGet(Supplier::new);
    }

    // UPDATE
    public Result editSupplier(Integer id, Supplier supplier) {
        boolean exists = supplierRepository.existsByNameAndPhoneNumber(supplier.getName(),supplier.getPhoneNumber());
        if (exists)
            return new Result("ERROR! This supplier already added", false);
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier editedSupplier = optionalSupplier.get();
            editedSupplier.setName(supplier.getName());
            editedSupplier.setActive(supplier.isActive());
            editedSupplier.setPhoneNumber(supplier.getPhoneNumber());

            supplierRepository.save(editedSupplier);

            return new Result("Supplier edited", true);
        }
        return new Result("ERROR! This supplier not found", false);
    }

    // DELETE
    public Result deleteSupplier(Integer id) {
        try {
            supplierRepository.deleteById(id);
            return new Result("Supplier deleted", true);
        } catch (Exception e) {
            return new Result("ERROR! This supplier not found", false);
        }
    }
}
