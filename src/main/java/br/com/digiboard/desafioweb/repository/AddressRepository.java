package br.com.digiboard.desafioweb.repository;

import br.com.digiboard.desafioweb.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
