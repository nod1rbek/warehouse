package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.entity.OutputProduct;
import uz.pdp.appwarehouse.entity.Product;

@Projection(types = OutputProduct.class)
public interface OutputProductProjection {
    Integer getId();

    Product getProduct();

    Double getAmount();

    Double getPrice();

    Output getOutput();
}
