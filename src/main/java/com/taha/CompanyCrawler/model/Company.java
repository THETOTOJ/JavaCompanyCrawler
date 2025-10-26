package com.taha.CompanyCrawler.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "companies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String registrationNumber;

    @Column(nullable = false)
    private String country;

    @Column(length = 500)
    private String address;

    private LocalDate incorporationDate;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    private String companyType;

    @Column(length = 2000)
    private String originalData;

    public enum CompanyStatus {
        ACTIVE, DISSOLVED, LIQUIDATION, UNKNOWN
    }
}