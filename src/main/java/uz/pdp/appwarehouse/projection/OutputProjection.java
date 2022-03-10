package uz.pdp.appwarehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.entity.Warehouse;

import java.sql.Timestamp;

@Projection(types = Output.class)
public interface OutputProjection {
    Integer getId();

    Timestamp getDate();

    Warehouse getWarehouse();

    Client getClient();

    Currency getCurrency();

    String getFactureNumber();

    String getCode();
}
