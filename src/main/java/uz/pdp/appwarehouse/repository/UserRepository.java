package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByPhoneNumberAndFirstNameAndLastName(String phoneNumber, String firstName, String lastName);
}
