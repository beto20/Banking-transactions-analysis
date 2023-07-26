package com.alberto.transactions.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // Customer information
    private String id;
    private String name;
    private String middleName;
    private String lastname;
    private String motherLastname;
    private IdentityDto identity;
    private String qualification; // investigado - aprobado - rechazado

    // Loan information
    private String accountNumber;
    private String disbursementAmount;
    private String disbursementDate;
    private String currency; // PEN, EUR, USD
    private String term;
    private String quota;
    private String interestRate;
    private Boolean hasInsurance;
    private InsuranceDto insurance;
    private String status;

    // Store information
    private String store;
    private String province;
    private String authorizer;

    // Timestamp information
    private String createdAt = LocalDateTime.now().toString();
    private String updatedAt = LocalDateTime.now().toString();

}
