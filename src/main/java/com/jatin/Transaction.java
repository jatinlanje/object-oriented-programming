package com.jatin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private TransactionType type;
    private double amount;
    private LocalDateTime date;

    public Transaction(TransactionType type, double amount){
        this.type=type;
        this.amount=amount;
        this.date=LocalDateTime.now();
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatter);

        return "Transaction: " + "Type = " + type + ", Date = " + formattedDate + ", Amount = " + amount;
    }
}
