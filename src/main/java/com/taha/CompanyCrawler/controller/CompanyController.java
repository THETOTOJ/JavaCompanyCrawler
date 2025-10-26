package com.taha.CompanyCrawler.controller;

import com.taha.CompanyCrawler.model.Company;
import com.taha.CompanyCrawler.service.CompanyCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyCrawlerService crawlerService;

    @PostMapping("/crawl")
    public ResponseEntity<Map<String, Object>> crawlCompanies() {
        int count = crawlerService.crawlAllCompanies();

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("companiesCrawled", count);
        response.put("countries", List.of("UK", "FRANCE", "GERMANY"));
        response.put("message", "Successfully crawled company data from 3 European countries");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Company>> searchCompanies(@RequestParam String q) {
        List<Company> companies = crawlerService.searchCompanies(q);
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Company>> getByCountry(@PathVariable String country) {
        List<Company> companies = crawlerService.getCompaniesByCountry(country);
        return ResponseEntity.ok(companies);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = crawlerService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }
}