package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Supplier;

@Projection(types = Supplier.class)
public interface SupplierProjection {
    Integer getId();

    String getName();

    boolean isActive();

    String getPhoneNumber();
}
