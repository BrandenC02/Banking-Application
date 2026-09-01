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
                System.out.println("Enter PIN for customer: " + customer.getName());
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
                System.out.println("Enter PIN for customer: " + customer.getName());
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

    public void transfer(){
        
    }
}