package lab.compulsory.repository;

import lab.compulsory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(@Param("id")Integer id);

    User findUsersByName(@Param("name")String name);

}
