
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        System.out.println("Welcome to the Bank!");//Debugging Start
        Customer customer1 = new Customer("John Doe", "Jdoe@gmail", "123 fake street", 1234, 1000);
        Bank bank = new Bank(customer1);
        bank.deposit(customer1.getAccountNumber());
        System.out.println("Thank you for using the bank!");//Debugging End



        
    }
}