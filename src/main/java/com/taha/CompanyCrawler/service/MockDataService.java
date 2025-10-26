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

        // Technology Companies
        companies.add(Company.builder()
                .name("Tech Innovations Ltd")
                .registrationNumber("UK12345678")
                .country("UK")
                .address("123 Silicon Street, London, EC1A 1BB")
                .incorporationDate(LocalDate.of(2020, 3, 15))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\",\"type\":\"technology\"}")
                .build());

        companies.add(Company.builder()
                .name("British Software Solutions")
                .registrationNumber("UK87654321")
                .country("UK")
                .address("456 Tech Avenue, Manchester, M1 1AA")
                .incorporationDate(LocalDate.of(2018, 7, 22))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\",\"type\":\"software\"}")
                .build());

        companies.add(Company.builder()
                .name("London Data Analytics PLC")
                .registrationNumber("UK11223344")
                .country("UK")
                .address("789 Analytics Road, London, SW1A 1AA")
                .incorporationDate(LocalDate.of(2019, 11, 5))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Public Limited Company")
                .originalData("{\"source\":\"UK Companies House\",\"type\":\"data analytics\"}")
                .build());

        // Financial Services
        companies.add(Company.builder()
                .name("FinTech Solutions UK Ltd")
                .registrationNumber("UK55667788")
                .country("UK")
                .address("200 Financial District, London, E14 5AB")
                .incorporationDate(LocalDate.of(2021, 1, 10))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\",\"type\":\"fintech\"}")
                .build());

        // E-commerce
        companies.add(Company.builder()
                .name("Digital Commerce Group")
                .registrationNumber("UK99887766")
                .country("UK")
                .address("50 Commerce Street, Birmingham, B1 1AA")
                .incorporationDate(LocalDate.of(2017, 6, 18))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\",\"type\":\"e-commerce\"}")
                .build());

        // Dissolved company for variety
        companies.add(Company.builder()
                .name("Old Tech Ventures Ltd")
                .registrationNumber("UK33445566")
                .country("UK")
                .address("Historical Building, Leeds, LS1 1BA")
                .incorporationDate(LocalDate.of(2010, 3, 5))
                .status(Company.CompanyStatus.DISSOLVED)
                .companyType("Private Limited Company")
                .originalData("{\"source\":\"UK Companies House\",\"dissolved\":\"2023-05-15\"}")
                .build());

        return companies;
    }

    public List<Company> getFrenchCompanies() {
        List<Company> companies = new ArrayList<>();

        // Technology
        companies.add(Company.builder()
                .name("Technologie Française SARL")
                .registrationNumber("FR123456789")
                .country("FRANCE")
                .address("10 Rue de la Technologie, 75001 Paris")
                .incorporationDate(LocalDate.of(2017, 5, 10))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("SARL")
                .originalData("{\"source\":\"Registre du Commerce\",\"format\":\"DD/MM/YYYY\",\"secteur\":\"technologie\"}")
                .build());

        companies.add(Company.builder()
                .name("Solutions Numériques SA")
                .registrationNumber("FR987654321")
                .country("FRANCE")
                .address("25 Avenue des Champs-Élysées, 75008 Paris")
                .incorporationDate(LocalDate.of(2015, 9, 18))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("SA")
                .originalData("{\"source\":\"Registre du Commerce\",\"format\":\"DD/MM/YYYY\",\"secteur\":\"digital\"}")
                .build());

        // Startups
        companies.add(Company.builder()
                .name("Innovation Start-up SAS")
                .registrationNumber("FR555666777")
                .country("FRANCE")
                .address("Station F, 5 Parvis Alan Turing, 75013 Paris")
                .incorporationDate(LocalDate.of(2022, 3, 1))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("SAS")
                .originalData("{\"source\":\"Registre du Commerce\",\"format\":\"DD/MM/YYYY\",\"secteur\":\"startup\"}")
                .build());

        // Consulting
        companies.add(Company.builder()
                .name("Conseil Technologique EURL")
                .registrationNumber("FR222333444")
                .country("FRANCE")
                .address("15 Boulevard Haussmann, 75009 Paris")
                .incorporationDate(LocalDate.of(2019, 7, 12))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("EURL")
                .originalData("{\"source\":\"Registre du Commerce\",\"format\":\"DD/MM/YYYY\",\"secteur\":\"conseil\"}")
                .build());

        return companies;
    }

    public List<Company> getGermanCompanies() {
        List<Company> companies = new ArrayList<>();

        // Technology
        companies.add(Company.builder()
                .name("Deutsche Technologie GmbH")
                .registrationNumber("DE123456789")
                .country("GERMANY")
                .address("Hauptstraße 100, 10115 Berlin")
                .incorporationDate(LocalDate.of(2016, 2, 28))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("GmbH")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"28.02.2016\",\"branche\":\"technologie\"}")
                .build());

        companies.add(Company.builder()
                .name("Berlin Software AG")
                .registrationNumber("DE987654321")
                .country("GERMANY")
                .address("Alexanderplatz 5, 10178 Berlin")
                .incorporationDate(LocalDate.of(2014, 12, 1))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("AG")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"01.12.2014\",\"branche\":\"software\"}")
                .build());

        // Engineering
        companies.add(Company.builder()
                .name("Ingenieur Systems GmbH")
                .registrationNumber("DE111222333")
                .country("GERMANY")
                .address("Industriestraße 50, 80331 München")
                .incorporationDate(LocalDate.of(2018, 5, 20))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("GmbH")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"20.05.2018\",\"branche\":\"engineering\"}")
                .build());

        // Automotive Tech
        companies.add(Company.builder()
                .name("AutoTech Innovation GmbH")
                .registrationNumber("DE444555666")
                .country("GERMANY")
                .address("Stuttgarter Straße 75, 70173 Stuttgart")
                .incorporationDate(LocalDate.of(2020, 9, 15))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("GmbH")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"15.09.2020\",\"branche\":\"automotive\"}")
                .build());

        // E-commerce
        companies.add(Company.builder()
                .name("E-Commerce Deutschland AG")
                .registrationNumber("DE777888999")
                .country("GERMANY")
                .address("Friedrichstraße 200, 10117 Berlin")
                .incorporationDate(LocalDate.of(2019, 4, 8))
                .status(Company.CompanyStatus.ACTIVE)
                .companyType("AG")
                .originalData("{\"source\":\"Handelsregister\",\"datum\":\"08.04.2019\",\"branche\":\"e-commerce\"}")
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

    // Utility method for statistics
    public int getTotalCompanyCount() {
        return getAllCompanies().size();
    }

    public int getCountByCountry(String country) {
        switch (country.toUpperCase()) {
            case "UK": return getUKCompanies().size();
            case "FRANCE": return getFrenchCompanies().size();
            case "GERMANY": return getGermanCompanies().size();
            default: return 0;
        }
    }
}