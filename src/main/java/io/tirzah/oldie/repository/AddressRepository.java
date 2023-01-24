package io.tirzah.oldie.repository;

import io.tirzah.oldie.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByCountry(String country);


}
