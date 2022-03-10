package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Category;

@Projection(types = {Category.class})
public interface CategoryProjection {
    Integer getId();

    String getName();

    boolean isActive();

    Category getParentCategory();
}
