package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.projection.OutputProjection;

@RepositoryRestResource(path = "output",excerptProjection = OutputProjection.class)
public interface OutputRepository extends JpaRepository<Output, Integer> {

}
