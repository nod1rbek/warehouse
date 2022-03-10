package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.projection.SupplierProjection;

@RepositoryRestResource(path = "supplier",excerptProjection = SupplierProjection.class)
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    boolean existsByNameAndPhoneNumber(String name, String phoneNumber);
}
