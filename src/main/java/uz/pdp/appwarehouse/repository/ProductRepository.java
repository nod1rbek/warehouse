package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.projection.ProductProjection;

@RepositoryRestResource(path = "product",excerptProjection = ProductProjection.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
