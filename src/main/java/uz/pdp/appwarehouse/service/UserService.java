package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.repository.UserRepository;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    // CREAT
    public Result addUser(UserDto userDto) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehousesId());
        boolean exists = warehouseRepository.existsById(userDto.getWarehousesId());
        if (exists)
            return new Result("ERROR! This warehouse already added", false);
        if (optionalWarehouse.isPresent()) {
            Warehouse warehouse = optionalWarehouse.get();
            User user = new User();

            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            user.setActive(userDto.isActive());
            Set<Warehouse> warehouses = new HashSet<>();
            warehouses.add(warehouse);
            user.setWarehouses(warehouses);

            userRepository.save(user);
            return new Result("User added", true);
        }
        return new Result("ERROR! This warehouse not found.Before warehouse added", false);
    }

    // READ
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ReadById
    public User getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    // UPDATE
    public Result editUser(Integer id, Integer warehouseId, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(warehouseId);
        boolean exists = userRepository.existsByPhoneNumberAndFirstNameAndLastName(userDto.getPhoneNumber(),userDto.getFirstName(),userDto.getLastName());
        if (exists) {
            return new Result("ERROR! This user already added", false);
        }
        if (optionalWarehouse.isPresent()) {
            if (optionalUser.isPresent()) {
                Warehouse warehouse = optionalWarehouse.get();
                Set<Warehouse> warehouses = new HashSet<>();
                warehouses.add(warehouse);

                User editedUser = optionalUser.get();
                editedUser.setFirstName(userDto.getFirstName());
                editedUser.setLastName(userDto.getLastName());
                editedUser.setPhoneNumber(userDto.getPhoneNumber());
                editedUser.setCode(userDto.getCode());
                editedUser.setPassword(userDto.getPassword());
                editedUser.setActive(userDto.isActive());
                editedUser.setWarehouses(warehouses);

                userRepository.save(editedUser);
                return new Result("User edited", true);
            } else return new Result("ERROR! This user not found", false);
        }
        return new Result("ERROR! Warehouse not found", false);
    }

    // DELETE
    public Result deleteUser(Integer id) {
        try {
            userRepository.findById(id);
            return new Result("User deleted", true);
        } catch (Exception e) {
            return new Result("This user not found", false);
        }
    }
}
