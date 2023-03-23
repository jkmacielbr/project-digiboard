package br.com.digiboard.desafioweb.controller;

import br.com.digiboard.desafioweb.model.Address;
import br.com.digiboard.desafioweb.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }


    public Address add(Address address) {
        return this.addressRepository.save(address);
    }
}
