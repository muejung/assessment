package com.kbtg.bootcamp.posttest.userticket;

import jakarta.persistence.*;

@Entity
@Table(name = "user_ticket")
public class UserTicket {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userid")
    private String userId;
    @Column(name = "ticketid")
    private String ticket;
    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;

    public UserTicket() {}

    public UserTicket(Long id, String userId, String ticket, int price, int amount) {
        this.id = id;
        this.userId = userId;
        this.ticket = ticket;
        this.price = price;
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
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
