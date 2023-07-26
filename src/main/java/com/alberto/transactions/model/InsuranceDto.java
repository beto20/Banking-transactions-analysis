package com.alberto.transactions.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InsuranceDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String product;
    private String policyNumber;
    private String paymentAmount;
    private String paymentFrequency;
    private String paymentCurrency;

    private String createdAt = LocalDateTime.now().toString();
    private String updatedAt = LocalDateTime.now().toString();
}
