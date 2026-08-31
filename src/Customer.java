
import java.util.Random;


public class Customer {
    //Attributes
    String name, email, address;
    int pin, accountnumber;
    double accountbalance;

    //Constructor
    public Customer(String name, String email, String address, int pin, double accountbalance) {
        setName(name);
        setEmail(email);
        setAddress(address);
        setPin(pin);
        setAccountBalance(accountbalance);
        setAccountNumber();
    }

    //Methods
    public void getCustomerInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("PIN: " + pin);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Account Balance: " + accountbalance);
    }

    

    //getters and setters
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    private void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    private void setPin(int pin) {
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountnumber;
    }

    private void setAccountNumber() {
        Random rand = new Random();
        int randomNum = rand.nextInt(999999 - 100000 + 1) + 100000;
        this.accountnumber = randomNum;
    }

    public double getAccountBalance() {
        return accountbalance;
    }

    protected void setAccountBalance(double accountbalance) {
        this.accountbalance = accountbalance;
    }


}
