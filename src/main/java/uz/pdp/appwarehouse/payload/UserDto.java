package uz.pdp.appwarehouse.payload;

import lombok.Data;


@Data
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String code;

    private String password;

    private boolean active = true;

    private Integer warehousesId;
}
