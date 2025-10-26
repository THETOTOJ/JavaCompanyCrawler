package com.taha.CompanyCrawler.repository;

import com.taha.CompanyCrawler.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByCountry(String country);

    Optional<Company> findByRegistrationNumber(String registrationNumber);

    List<Company> findByNameContainingIgnoreCase(String name);

    List<Company> findTop100ByOrderByNameAsc();
}