package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.Product;

@Projection(types = Product.class)
public interface ProductProjection {
    Integer getId();

    String getName();

    boolean isActive();

    Category getCategory();

    Attachment getPhoto();

    String getCode();

    Measurement getMeasurement();
}
