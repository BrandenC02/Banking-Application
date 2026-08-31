import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    //Attributes
    private List<Customer> customers;
    int pin, accountnumber;
    Scanner scanner = new Scanner(System.in);

    //Constructor
    public Bank(Customer customer, int pin) {
        customers = new ArrayList<>();
        this.customers.add(customer);
        this.pin = pin;
    }

    //Methods
    public void deposit(){
        for (Customer customer : customers) {
            if (customer.getPin() == pin) {
                customer.setAccountBalance(customer.getAccountBalance() + 100.0); 
                System.out.println("Deposit successful for customer: " + customer.getName());
                System.out.println("new Account Balance: " + customer.getAccountBalance());
                return;
            }
        }
    }

    public void withdraw(){
        for (Customer customer : customers) {
            if (customer.getPin() == pin) {
                customer.setAccountBalance(customer.getAccountBalance() - 100.0); 
                System.out.println("Withdrawal successful for customer: " + customer.getName());
                System.out.println("new Account Balance: " + customer.getAccountBalance());
                return;
            }
        }
    }

    public void transfer(){

    }
}