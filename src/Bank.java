import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    //Attributes
    private List<Customer> customers;
    int pin, accountnumber;
    Scanner scanner = new Scanner(System.in);

    //Constructor
    public Bank(Customer customer) {
        customers = new ArrayList<>();
        customers.add(customer);
    }

    //Methods
    public void deposit(int acctnumber) {
        for (Customer customer : customers) {//For each customer in list of customers, check if the account number matches the input account number
            if (customer.getAccountNumber() == acctnumber) {
                while (true) {
                try{//If pin is invalid, catch the exception and prompt the user to enter a valid pin
                System.out.println("Enter PIN for customer: " + customer.getName());//Ask for pin in every transaction to ensure security
                int enteredPIN = scanner.nextInt();
                while (enteredPIN != customer.getPin()) {
                    System.out.println("Incorrect PIN. Please try again.");
                    enteredPIN = scanner.nextInt();
                }
                if (enteredPIN == customer.getPin()) {//If pin is valid, prompt the user to enter the amount to deposit
                    System.out.println("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    customer.setAccountBalance(customer.getAccountBalance() + amount);//Set new account balance
                }
                System.out.println("Deposit successful for customer: " + customer.getName());//Confirmation message
                System.out.println("new Account Balance: " + customer.getAccountBalance());//Display new account balance
                break;
                } catch (Exception e) {//Catch exception if pin is invalid
                System.out.println("Invalid input. Please enter Numerical input only.");
                scanner.nextLine(); // Clear the invalid input
                }
                }
            }
        }
    }

    public void withdraw(int acctnumber){
        for (Customer customer : customers) {//For each customer in list of customers, check if the account number matches the input account number
            if (customer.getAccountNumber() == acctnumber) {
                while (true) {
                try{//If pin is invalid, catch the exception and prompt the user to enter a valid pin
                System.out.println("Enter PIN for customer: " + customer.getName());//Ask for pin in every transaction to ensure security
                int enteredPIN = scanner.nextInt();
                while (enteredPIN != customer.getPin()) {
                    System.out.println("Incorrect PIN. Please try again.");
                    enteredPIN = scanner.nextInt();
                }
                if (enteredPIN == customer.getPin()) {//If pin is valid, prompt the user to enter the amount to withdraw
                    System.out.println("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    customer.setAccountBalance(customer.getAccountBalance() - amount);//Set new account balance
                }
                System.out.println("Withdrawal successful for customer: " + customer.getName());//Confirmation message
                System.out.println("new Account Balance: " + customer.getAccountBalance());//Display new account balance
                break;
                } catch (Exception e) {//Catch exception if pin is invalid
                System.out.println("Invalid input. Please enter Numerical input only.");
                scanner.nextLine(); // Clear the invalid input
                }
                }
            }
        }
    }

    public void transfer(int accountnumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber() == accountnumber) {
                System.out.println("Enter PIN for customer: " + customer.getName());//Ask for pin in every transaction to ensure security
                int enteredPIN = scanner.nextInt();
                while(true){
                    try{
                        while (enteredPIN != customer.getPin()) {
                            System.out.println("Incorrect PIN. Please try again.");
                            enteredPIN = scanner.nextInt();
                        }   
                        System.out.println("Enter amount to transfer: ");
                        double transfer = scanner.nextDouble();
                        customer.setAccountBalance(customer.getAccountBalance() - transfer);
                        //second customer to transfer to
                        System.out.println("Enter account number of recipient: ");
                        int recipientAccountNumber = scanner.nextInt();
                        for (Customer recipient : customers) {
                            if (recipient.getAccountNumber() == recipientAccountNumber) { // Ensure recipient exists
                                recipient.setAccountBalance(recipient.getAccountBalance() + transfer);
                                System.out.println("Transfer successful from " + customer.getName() + " to " + recipient.getName());
                                System.out.println(customer.getName() + "'s new Account Balance: " + customer.getAccountBalance());
                                System.out.println(recipient.getName() + "'s new Account Balance: " + recipient.getAccountBalance());
                                return;
                            }
                        }
                    }
                    catch (Exception e) {//Catch exception if pin is invalid
                    System.out.println("Invalid input. Please enter Numerical input only.");
                    scanner.nextLine(); // Clear the invalid input
                    }
                }
            }
        }
    }


    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void viewcustomerList() {
        System.out.println("List of Customers:");
        for (Customer customer : customers) {
            customer.getCustomerInfo();
            System.out.println("--------------------");
        }
    }

    public void viewCustomerInfo(int acctnumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber() == acctnumber) {
                System.out.println("Customer Information:");
                customer.getCustomerInfo();
                return;
            }
        }
        System.out.println("Customer with account number " + acctnumber + " not found.");
    }


}