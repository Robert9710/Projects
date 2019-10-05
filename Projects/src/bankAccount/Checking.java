package bankAccount;

public class Checking extends Account{
    //List properties specific to a Checking account
    private int debitCardNumb;
    private int debitCardPIN;
    
    //Constructor to initialize Checking account properties
    public Checking(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        accNumb = "2" + accNumb;
        setDebitCard();
    }
    
    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }
    
    //List methods specific to a Checking account
    private void setDebitCard(){
        debitCardNumb = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }
    
    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Account Type: Checking");
        System.out.println("Debit Card Number: " + debitCardNumb +
                "\nDebit Card PIN" + debitCardPIN);
    }
}
