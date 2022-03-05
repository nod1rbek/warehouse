package uz.pdp.appwarehouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Warehouse extends AbsEntity {

    public Warehouse(String name, boolean active) {
        super(name, active);
    }
}
