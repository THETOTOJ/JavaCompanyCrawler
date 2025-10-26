package com.taha.CompanyCrawler.service;

import com.taha.CompanyCrawler.model.Company;
import com.taha.CompanyCrawler.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CompanyCrawlerService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MockDataService mockDataService;

    public int crawlAllCompanies() {
        log.info("Starting company data crawling...");

        // Clear existing data to avoid duplicate key errors
        companyRepository.deleteAll();
        log.info("Cleared existing company data");

        // Get companies from all sources
        List<Company> allCompanies = mockDataService.getAllCompanies();

        // Save to database
        List<Company> savedCompanies = companyRepository.saveAll(allCompanies);

        log.info("Crawled and saved {} companies", savedCompanies.size());

        return savedCompanies.size();
    }

    public List<Company> searchCompanies(String query) {
        return companyRepository.findByNameContainingIgnoreCase(query);
    }

    public List<Company> getCompaniesByCountry(String country) {
        return companyRepository.findByCountry(country.toUpperCase());
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}