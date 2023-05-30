package com.jatin;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws BankException {
        BankManagementSystem bankManagementSystem=new BankManagementSystem();
        bankManagementSystem.setUserRole(UserRole.ADMINISTRATOR);

        bankManagementSystem.createAccount(Bank.BANK_OF_BARODA,"Jainam Shah",23965296410L,2000);
        bankManagementSystem.createAccount(Bank.BANK_OF_BARODA,"Jay Abhani",32872173531L,3000);
        bankManagementSystem.createAccount(Bank.STATE_BANK_OF_INDIA,"Jatin Lanje",68493145229L,1000);

        bankManagementSystem.performTransfer(23965296410L,68493145229L,1000);
        bankManagementSystem.displayTransactionHistory(23965296410L);

        bankManagementSystem.sortAccountsByBalance();
    }
}