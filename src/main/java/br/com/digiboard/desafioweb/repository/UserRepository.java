package br.com.digiboard.desafioweb.repository;

import br.com.digiboard.desafioweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
