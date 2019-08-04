package email;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String alternativeEmail;
    private String companySuffix = "xyzcompany.com";
    
    //Constructor
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        
        //Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Dept is: " + department);
        
        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Pasword:" + password);
        
        //Combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email: " + email);
    }
    
    //Ask for department
    private String setDepartment(){
        System.out.print("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\nEnter the department: ");
        Scanner scan = new Scanner(System.in);
        int depChoice = scan.nextInt();
        if(depChoice == 1){
            return "sales";
        }else if(depChoice == 2){
            return "dev";
        }else if(depChoice == 3){
            return "acct";
        }else{
            return "";
        }
    }
    
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$%&";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    
    //Set alternative email
    public void setAlternativeEmail(String altEmail){
        this.alternativeEmail = altEmail;
    }
    
    //Change the password
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    
    public String getAlternativeEmail(){
        return alternativeEmail;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String showInfo(){
        return "Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity:" + mailboxCapacity + " MB";
    }
}
