package uz.pdp.appwarehouse.entity;

import lombok.*;
import uz.pdp.appwarehouse.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Category extends AbsEntity {
    @ManyToOne
    private Category parentCategory;
}
