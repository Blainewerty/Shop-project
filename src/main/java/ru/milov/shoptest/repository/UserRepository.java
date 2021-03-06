package ru.milov.shoptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.milov.shoptest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    User findByActivationCode(String code);
}
