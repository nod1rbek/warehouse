package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.projection.MeasurementProjection;

@RepositoryRestResource(path = "measurement",excerptProjection = MeasurementProjection.class)
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    boolean existsByName(String name);
}
