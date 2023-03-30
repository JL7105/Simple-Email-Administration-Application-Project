package EmailApp;
import java.util.Scanner;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Need to recieve first and last name.
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName + "\n");

        // Call method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Deparment: " +  this.department);

        // Call method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is:  " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is : " + email);
    }

    // Need to ask for department.
    private String setDepartment() {
        System.out.print("DEPARMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        
        switch (depChoice) {

            case 1:
                return "sales";

            case 2:
                return "dev";

            case 3:
                return "acct";

            default:
                return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!&$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    // Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change password
    public void setPassword(String password) {
        this.password = password;
    }

    public String displayInformation() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " +  mailboxCapacity + "mb";

    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }


}



