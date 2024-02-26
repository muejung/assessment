package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;

@Entity
@Table(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ticketid")
    private String ticket;
    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;

    public Lottery() {}

    public Lottery(Long id, String ticket, int price, int amount) {
        this.id = id;
        this.ticket = ticket;
        this.price = price;
        this.amount = amount;
    }

    public void setTicketId(Long ticketId) {
        this.id = id;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getTicketId() {
        return id;
    }

    public String getTicket() {
        return ticket;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}

