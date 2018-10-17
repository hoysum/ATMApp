package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static AccountClass currentAccount;
    static ArrayList<AccountClass> accounts = new ArrayList<>();
    public static void main(String[] args) {

        accounts.add(new AccountClass("45022", "John Doe", 10, "0828"));
        accounts.add(new AccountClass("45023", "Mary Doe", 1000, "0742"));
        accounts.add(new AccountClass("45024", "Alice Smith", 3000, "1453"));
        accounts.add(new AccountClass("45025", "Mike Jones", 5000, "0077"));

        int counter = 0;
        String accountnum;
        String pin;

        do {
            System.out.println("Enter Account number");
            accountnum= in.nextLine();
            System.out.println("Enter PIN");
             pin= in.nextLine();
            counter++;

            System.out.println(checkInputs(accountnum,pin));
        } while (!checkInputs(accountnum,pin) && counter < 3);

        if(counter >3){
        System.out.println("More than 3 wrong attempts, You have been locked out");}
        else {
            for (AccountClass account : accounts) {
                if (account.getAccountNumber().equalsIgnoreCase(accountnum) && account.getPin().equalsIgnoreCase(pin)) {
                   currentAccount = account;//declare currentAccount
            }
            }customerChoices(currentAccount);
        }
    }
    public static boolean checkInputs(String accountnum, String pin) {
        for (AccountClass account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountnum) && account.getPin().equalsIgnoreCase(pin)) {
            return true;
            }
        }
        return false;
    }
    public static void customerChoices(AccountClass account) {
        System.out.println("Enter d of deposit, w for withdrawal or c to check balance");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        getOptions(response);
    }
     public static void getOptions(String response){
            if(response.equalsIgnoreCase("d")){
             System.out.println("Enter an amount to deposit");
             double deposit = in.nextDouble();
             currentAccount.makeDeposit(deposit);
                getOutpu("Username: ", "Deposit Amount: ", deposit);
                System.out.println("Ending Balance: " + "$"+currentAccount.getBalance());

         }else if (response.equalsIgnoreCase("w")){
             System.out.println("Enter an amount to withdraw");
             double withdrawal = in.nextDouble();
             if(currentAccount.getBalance()<withdrawal){
                 System.out.println("Insufficient funds, withdrawal not allowed");
                 getOutpu("Username:", "Balance ", currentAccount.getBalance());
             }
             currentAccount.makeWithdrawwal(withdrawal);
                getOutpu("Username: ", "Withdrawal Amount ", withdrawal);
                System.out.println("Balance " + "$"+currentAccount.getBalance());

         }else if(response.equalsIgnoreCase("c")){
                getOutpu("Username: ", "Your balance is ", currentAccount.getBalance());
            }
        }

    private static void getOutpu(String s, String s2, double balance) {
        System.out.println(s + currentAccount.getUserName());
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println(s2 + "$" + balance);
    }

}




