package com.company;

public class AccountClass {

    private String accountNumber;
    private String userName;
    private double balance;
    private String pin;

    public AccountClass() {
    }

    public AccountClass(String accountNumber, String userName, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void makeDeposit(double deposit){
        balance = balance + deposit;

    }
    public void makeWithdrawwal(double withdrawal){
        balance = balance - withdrawal;
    }

}


