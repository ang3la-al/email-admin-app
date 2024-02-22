import java.util.Scanner;

public class Email {
    
    private String firstName;
    private String lastName;
    private String password;
    private int initialPasswordLength = 12; 
    private String department;
    private String personalEmail;
    private String companyTag = "company.com";
    private String email;

    // Receives first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("new email: " + this.firstName + " " + this.lastName);
        
        // call method which asks for department
        this.department = setDepartment();
        System.out.println("You selected " + this.department);
    
        // returning random password
        this.password = generatePassword(initialPasswordLength);
        System.out.println("Your password is: " + this.password);

       this.email = firstName + lastName + "." + department + "@" + companyTag;
    }


    // Get department
    private String setDepartment() {
        int department = validInt("Department information: \n1 for Sales\n2 for Accounting\n3 for Development\n0 for none \n Please enter a number: ");

        if (department == 1) {
            return "Sales";
        } else if (department == 2) {
            return "Accounting";
        } else if (department == 3) {
            return "Development";
        } else if (department == 0) {
            return "None";
        } else {
            return "";
        }
    }
    // Generate random password
    private String generatePassword(int length) {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/*-+!£$%^&";
        char[] password = new char[length];
        
        for (int i = 0; i<length; i++) {
            int random = (int) (Math.random()*allowedCharacters.length());
            password[i] = allowedCharacters.charAt(random);
        }
        
        return new String(password);
    }


    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;
    }
    

    public String getPersonalEmail() {
        return personalEmail;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String showEmployeeInformation () {
        return "Display name: " + firstName + " " + lastName + "\n" +
        "Company Email: " + email;
    }
    
    // gets user input as a string
    //
    public static String inputString (String message)
    {
            String answer;
            Scanner scanner = new Scanner(System.in);
    
            System.out.println(message);
            answer = scanner.nextLine();
        
            return answer;
        } // END inputString

    // gets user to input an string
    // converts to an integer input, which should be between 0-3
    //
    public static int validInt (String message)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(message);

        int input = Integer.parseInt(keyboard.nextLine());
        if (input<0 || input>3){
            input = validInt("Please input a valid number between 0-3");
        }

        return input;
    } 
}
