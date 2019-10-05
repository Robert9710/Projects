package bankAccount;

public class Savings extends Account{
    //List properties specific to a Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;
    
    //Constructor to initialize Savings account properties
    public Savings(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        accNumb = "1" + accNumb;
        setSafetyDepositBox();
    }
    
    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }
    
    //List methods specific to a Savings account
    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }
    
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Safety Deposit Box ID: " + safetyDepositBoxID +
                "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
    }
}
