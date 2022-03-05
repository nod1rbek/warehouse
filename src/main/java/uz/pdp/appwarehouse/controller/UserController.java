package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Result addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Result editUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.editUser(id, userDto.getWarehousesId(), userDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
