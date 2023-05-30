package com.jatin;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Bank bank;
    private String name;
    private long accountNumber;
    private String ifsc;
    private double balance;
    private List<Transaction> transactionHistory;


    public Account(Bank bank, String name, long accountNumber, double initialDeposit){
        this.bank=bank;
        this.name=name;
        this.accountNumber=accountNumber;
        this.ifsc=generateIFSC(bank);
        this.balance=initialDeposit;
        this.transactionHistory = new ArrayList<>();
    }

    public Bank getBank(){
        return this.bank;
    }

    public String getName(){
        return this.name;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public String getIfsc(){
        return this.ifsc;
    }

    public double getBalance(){
        return this.balance;
    }

    public String generateIFSC(Bank bank){
        StringBuilder initials = new StringBuilder();
        String[] words = bank.toString().split("_");
        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.charAt(0));
            }
        }
        return initials.toString().toUpperCase();
    }

    public void deposit(double amount){
        this.balance+=amount;
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
        transactionHistory.add(transaction);
    }

    public void withdrawal(double amount) throws BankException {
        if(this.balance>=amount){
            this.balance-=amount;
            Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount);
            transactionHistory.add(transaction);
        }
        else{
            throw new BankException("Insufficient balance.");
        }
    }

    public void transfer(Account sender, Account receiver, double amount){
        sender.balance-=amount;
        receiver.balance+=amount;
        Transaction transaction=new Transaction(TransactionType.TRANSFER, amount);
        transactionHistory.add(transaction);
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account Name = " + name + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
