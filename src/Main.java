import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        /*
        System.out.println("Welcome to the Bank!");//Debugging Start
        Customer customer1 = new Customer("John Doe", "Jdoe@gmail", "123 fake street", 1234, 1000);
        Bank bank = new Bank(customer1);
        bank.deposit(customer1.getAccountNumber());
        System.out.println("Thank you for using the bank!");//Debugging End
        */
        Customer customer1 = new Customer("John Doe", "Jdoe@gmail", "123 fake street", 1234, 1000);
        Customer customer2 = new Customer("Jane Smith", "Jsmith@gmail", "456 real street", 5678, 500);
        Customer customer3 = new Customer("Bob Johnson", "BJohnson@gmail", "789 another street", 9012, 2000);
        Customer customer4 = new Customer("Alice Brown", "ABrown@gmail", "321 some street", 3456, 1500);
        Bank bank = new Bank(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);
        bank.addCustomer(customer4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank!");
        while (true) {
        System.out.println("Create a new account or view existing account(s)? (Enter 'create', 'view', or 'exit' to quit)");
        try{
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("create")) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Enter your address: ");
            String address = scanner.nextLine();
            System.out.println("Enter a 4-digit PIN: ");
            int pin = scanner.nextInt();
            System.out.println("Enter initial deposit amount: ");
            double accountbalance = scanner.nextDouble();
            Customer newCustomer = new Customer(name, email, address, pin, accountbalance);
            bank.addCustomer(newCustomer);
            System.out.println("Account created successfully!");
            newCustomer.getCustomerInfo();
            scanner.nextLine();
        }else if (choice.equals("view")) {
           System.out.println("If you have an account number, please enter it to view your account details. If you would like to view all customers, please enter 'all'.");
           String input = scanner.nextLine();
           if (input.equalsIgnoreCase("all")) {
            bank.viewcustomerList();
           }else{
            try {
                int acctnumber = Integer.parseInt(input);
                bank.viewCustomerInfo(acctnumber);
                while (true) {
                System.out.println("Would you like to deposit, withdraw, or transfer? (Enter 'deposit', 'withdraw', or 'transfer', or 'none' to exit)");
                String action = scanner.nextLine().toLowerCase();
                if (action.equals("deposit")) {
                    bank.deposit(acctnumber);
                } else if (action.equals("withdraw")) {
                    bank.withdraw(acctnumber);
                } else if (action.equals("transfer")) {
                    bank.transfer(acctnumber);
                } else if (action.equals("none")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please restart the program and enter 'deposit', 'withdraw', 'transfer', or 'none'.");
                }
            }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid account number or 'all'.");
            }
           }
        } else if(choice.equals("exit")) {
            System.out.println("Thank you for using the bank!");
            break;
        } else {
            System.out.println("Invalid choice. Please restart the program and enter 'create', 'view', or 'exit'.");
        }
    }
    catch (Exception e) {
        System.out.println("Invalid input. Please enter valid information.");
        scanner.nextLine(); // Clear the invalid input
    }
    }
    }
}
