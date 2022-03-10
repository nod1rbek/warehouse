package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Client;

@Projection(types = Client.class)
public interface ClientProjection {
    Integer getId();

    String getName();

    boolean isActive();

    String getPhoneNumber();
}
