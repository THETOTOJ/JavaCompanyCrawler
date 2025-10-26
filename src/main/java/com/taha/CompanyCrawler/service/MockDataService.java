package com.taha.CompanyCrawler.service;

import com.taha.CompanyCrawler.model.Company;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MockDataService {

    public List<Company> getUKCompanies() {
        List<Company> companies = new ArrayList<>();

        companies.add(Company.builder()
                .name("Tech Innovations Ltd")
                .registrationNumber("UK12345678")
                .country("UK")
                .address("123 Silicon Street, London, EC1A 1BB")
                .incorporationDate(LocalDate.of(2020, 3, 15))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\"}")
                .build());

        companies.add(Company.builder()
                .name("British Software Solutions")
                .registrationNumber("UK87654321")
                .country("UK")
                .address("456 Tech Avenue, Manchester, M1 1AA")
                .incorporationDate(LocalDate.of(2018, 7, 22))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\"}")
                .build());

        companies.add(Company.builder()
                .name("London Data Analytics")
                .registrationNumber("UK11223344")
                .country("UK")
                .address("789 Analytics Road, London, SW1A 1AA")
                .incorporationDate(LocalDate.of(2019, 11, 5))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Public Limited Company")
                .originalData("{\"source\":\"UK Companies House\"}")
                .build());

        return companies;
    }

    public List<Company> getFrenchCompanies() {
        List<Company> companies = new ArrayList<>();

        companies.add(Company.builder()
                .name("Technologie Française SARL")
                .registrationNumber("FR123456789")
                .country("FRANCE")
                .address("10 Rue de la Technologie, 75001 Paris")
                .incorporationDate(LocalDate.of(2017, 5, 10))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("SARL")
                .originalData("{\"source\":\"Registre du Commerce\",\"format\":\"DD/MM/YYYY\"}")
                .build());

        companies.add(Company.builder()
                .name("Solutions Numériques SA")
                .registrationNumber("FR987654321")
                .country("FRANCE")
                .address("25 Avenue des Champs-Élysées, 75008 Paris")
                .incorporationDate(LocalDate.of(2015, 9, 18))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("SA")
                .originalData("{\"source\":\"Registre du Commerce\",\"format\":\"DD/MM/YYYY\"}")
                .build());

        return companies;
    }

    public List<Company> getGermanCompanies() {
        List<Company> companies = new ArrayList<>();

        companies.add(Company.builder()
                .name("Deutsche Technologie GmbH")
                .registrationNumber("DE123456789")
                .country("GERMANY")
                .address("Hauptstraße 100, 10115 Berlin")
                .incorporationDate(LocalDate.of(2016, 2, 28))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("GmbH")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"28.02.2016\"}")
                .build());

        companies.add(Company.builder()
                .name("Berlin Software AG")
                .registrationNumber("DE987654321")
                .country("GERMANY")
                .address("Alexanderplatz 5, 10178 Berlin")
                .incorporationDate(LocalDate.of(2014, 12, 1))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("AG")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"01.12.2014\"}")
                .build());

        return companies;
    }

    public List<Company> getAllCompanies() {
        List<Company> allCompanies = new ArrayList<>();
        allCompanies.addAll(getUKCompanies());
        allCompanies.addAll(getFrenchCompanies());
        allCompanies.addAll(getGermanCompanies());
        return allCompanies;
    }
}