package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Warehouse;


public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    Iterable<Warehouse> findAllById(Integer id);
    boolean existsByName(String name);
}
