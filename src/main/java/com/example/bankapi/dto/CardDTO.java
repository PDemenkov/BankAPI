package com.example.bankapi.dto;


import java.util.Objects;

public class CardDTO {

    private int id;
    private String cardNumber;
    private String cvv;
    private String expDate;

    public CardDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDTO cardDTO = (CardDTO) o;
        return id == cardDTO.id && cardNumber.equals(cardDTO.cardNumber) && cvv.equals(cardDTO.cvv) && expDate.equals(cardDTO.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cvv, expDate);
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
