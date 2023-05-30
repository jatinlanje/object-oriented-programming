package com.jatin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankManagementSystem {
    private final Integer MIN_BALANCE=1000;
    private List<Account> accounts;
    private UserRole userRole;

    public BankManagementSystem(){
        this.accounts=new ArrayList<>();
    }

    public void setUserRole(UserRole userRole){
        this.userRole=userRole;
    }

    public void createAccount(Bank bank, String name, long accountNumber, double initialDeposit) throws BankException{
        if (userRole != UserRole.ADMINISTRATOR) {
            throw new BankException("You don't have permission to create an account.");
        }
        for(Account account:accounts){
            if(account.getAccountNumber() == accountNumber){
                throw new BankException("Account number already exists. Please choose a different account number.");
            }
        }
        if(initialDeposit<MIN_BALANCE){
            throw new BankException("Initial Deposit must be greater than or equals to "+MIN_BALANCE);
        }
        String accountNumberRegex = "\\d{11}";
        if (!String.valueOf(accountNumber).matches(accountNumberRegex)) {
            throw new BankException("Invalid account number format. Please enter a valid account number.");
        }
        int minNameLength = 2;
        int maxNameLength = 50;
        if (name.length() < minNameLength || name.length() > maxNameLength) {
            throw new BankException("Invalid customer name length. Please enter a name between " + minNameLength +
                    " and " + maxNameLength + " characters.");
        }
        Account account=new Account(bank, name, accountNumber, initialDeposit);
        accounts.add(account);
        System.out.println("Account created successfully.");
        displayAccountInfo(accountNumber);
    }

    public Account findAccount(long accountNumber){
        for(Account account:accounts){
            if(account.getAccountNumber()==accountNumber){
                return account;
            }
        }
        return null;
    }

    public void performDeposit(long accountNumber, double amount) throws BankException {
        Account account=findAccount(accountNumber);
        if(account!=null){
            account.deposit(amount);
            System.out.println("Deposit Successful. Current balance: "+account.getBalance());
        }
        else{
            throw new BankException("Account not found.");
        }
    }

    public void performWithdrawal(long accountNumber, double amount) throws BankException {
        Account account=findAccount(accountNumber);
        if(account!=null){
            account.withdrawal(amount);
            System.out.println("Withdrawal Successful. Current balance: "+account.getBalance());
        }
        else{
            throw new BankException("Account not found.");
        }
    }

    public void performTransfer(long senderAccountNumber, long receiverAccountNumber, double amount) throws BankException {
        Account sender=findAccount(senderAccountNumber);
        Account receiver=findAccount(receiverAccountNumber);
        if(sender!=null && receiver!=null){
            sender.transfer(sender,receiver,amount);
            System.out.println("Transaction Successful.");
            System.out.println("-----------------------------");
        }
        else{
            throw new BankException("Account not found.");
        }
    }

    public void displayAccountInfo(long accountNumber) throws BankException {
        Account account=findAccount(accountNumber);
        if(account!=null){
            System.out.println("Name: "+account.getName());
            System.out.println("Account Number: "+account.getAccountNumber());
            System.out.println("Balance: "+account.getBalance());
            System.out.println("Bank: "+account.getBank());
            System.out.println("IFSC: "+account.getIfsc());
            System.out.println("-----------------------------");
        }
        else{
            throw new BankException("Account not found.");
        }
    }

    public void sortAccountsByBalance() {
        Collections.sort(accounts, Comparator.comparingDouble(Account::getBalance));
        System.out.println("Accounts sorted by Balance:");
        displayAccounts(accounts);
    }

    private void displayAccounts(List<Account> accountList) {
        for (Account account : accountList) {
            System.out.println("Name: "+account.getName());
            System.out.println("Account Number: "+account.getAccountNumber());
            System.out.println("Balance: "+account.getBalance());
            System.out.println("Bank: "+account.getBank());
            System.out.println("IFSC: "+account.getIfsc());
            System.out.println("-----------------------------");
        }
    }

    public void displayTransactionHistory(long accountNumber) throws BankException {
        Account account=findAccount(accountNumber);
        if(account!=null){
            account.displayTransactionHistory();
            System.out.println("-----------------------------");
        }
        else{
            throw new BankException("Account not found.");
        }
    }


}
