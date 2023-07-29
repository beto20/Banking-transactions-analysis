package com.alberto.transactions.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreditCardDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // Customer information
    private String id;
    private String name;
    private String middleName;
    private String lastname;
    private String document;
    private String number;
    private String qualification; // investigado - aprobado - rechazado

    // CreditCard information
    private String creditLine;
    private String cardExpiration;
    private String cardNumber;
    private String cardBrand;
    private String cardType;
    private String disbursementAmount;
    private String disbursementDate;
    private String currency; // PEN, EUR, USD
    private String interestRate;
    private Boolean hasInsurance;
    private String status;

    // Insurance information
    private String product;
    private String policyNumber;
    private String paymentAmount;
    private String paymentFrequency;
    private String paymentCurrency;

    // Location information
    private String store;
    private String province;

    // Timestamp information
    private String createdAt = LocalDateTime.now().toString();
    private String updatedAt = LocalDateTime.now().toString();
}
