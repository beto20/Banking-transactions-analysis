package com.alberto.transactions.model;


import java.io.Serializable;
import java.time.LocalDateTime;

public class TransactionDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String middleName;
    private String lastname;
    private String motherLastname;
    private Identity identity;
    private String totalAmount;
    private String date;
    private String creditLine;
    private String expirationDate;
    private String cardNumber;
    private String cardBrand;
    private String cardType;
    private String clientResult; // investigado - aprobado - rechazado
    private String currency; // PEN, EUR, USD

    private String createdAt = LocalDateTime.now().toString();
    private String updatedAt = LocalDateTime.now().toString();

    public static class Identity implements Serializable {
        private static final long serialVersionUID = 1L;
        private String document;
        private String number;

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Identity() {
        }

        public Identity(String document, String number) {
            this.document = document;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Identity{" +
                    "document='" + document + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

    public TransactionDto() {
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", motherLastname='" + motherLastname + '\'' +
                ", identity=" + identity +
                ", totalAmount='" + totalAmount + '\'' +
                ", date='" + date + '\'' +
                ", creditLine='" + creditLine + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardBrand='" + cardBrand + '\'' +
                ", cardType='" + cardType + '\'' +
                ", clientResult='" + clientResult + '\'' +
                ", currency='" + currency + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public TransactionDto(String id, String name, String middleName, String lastname, String motherLastname, Identity identity, String totalAmount, String date, String creditLine, String expirationDate, String cardNumber, String cardBrand, String cardType, String clientResult, String currency, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.middleName = middleName;
        this.lastname = lastname;
        this.motherLastname = motherLastname;
        this.identity = identity;
        this.totalAmount = totalAmount;
        this.date = date;
        this.creditLine = creditLine;
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
        this.cardBrand = cardBrand;
        this.cardType = cardType;
        this.clientResult = clientResult;
        this.currency = currency;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMotherLastname() {
        return motherLastname;
    }

    public void setMotherLastname(String motherLastname) {
        this.motherLastname = motherLastname;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getClientResult() {
        return clientResult;
    }

    public void setClientResult(String clientResult) {
        this.clientResult = clientResult;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
