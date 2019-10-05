package bankAccount;

import sun.security.x509.UniqueIdentity;

public abstract class Account implements IBaseRate{
    //List common properties for savings and checking accounts
    private String name;
    private String ssn;
    private double balance;
    private static int index = 10000; 
    protected String accNumb;
    protected double rate;
    
    //Constructor to set base properties and initialize the account
    public Account(String name, String ssn, double initDeposit){
        this.name = name;
        this.ssn = ssn;
        this.balance = initDeposit;
        
        //Set account number
        this.accNumb = setAccountNumber();
        
        setRate();
    }
    
    public abstract void setRate();
    
    private String setAccountNumber(){
        
        String lastTwoOfSnn = ssn.substring(ssn.length()-2, ssn.length());
        int uniqueID = index;
        int randomNumber = (int)(Math.random() * Math.pow(10, 3));
        return lastTwoOfSnn + uniqueID + randomNumber;
    }
    
    public void compound(){
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
    }
    
    //List common methods
    public void deposit(double amount){
        this.balance += amount;
        printBalance();
    }
    
    public void withdraw(double amount){
        this.balance -= amount;
        printBalance();
    }
    
    public void transfer(String location, double amount){
        this.balance -= amount;
        System.out.println(amount + "transfered to" + location);
        printBalance();
    }
    
    public void printBalance(){
        System.out.println("Your new balance is: " + balance);
    } 
    
    public void showInfo(){
        System.out.println("Name: " + name +
                "\nAccount Number: " + accNumb +
                "\nBalance: " + balance +
                "\nRate: " + rate + "%");
    }
    
}
