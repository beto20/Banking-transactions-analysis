package com.alberto.transactions.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IdentityDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String document;
    private String number;
}