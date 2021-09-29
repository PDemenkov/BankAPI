package com.example.bankapi.entity;



import javax.persistence.*;
import java.util.Objects;

@Entity

@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvv")
    private String CVV;

    @Column(name = "exp_date")
    private String expDate;

    public Card() {
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

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
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
        Card card = (Card) o;
        return id == card.id && cardNumber.equals(card.cardNumber) && CVV.equals(card.CVV) && expDate.equals(card.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, CVV, expDate);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", CVV='" + CVV + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}

