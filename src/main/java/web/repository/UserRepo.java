package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import web.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
}
