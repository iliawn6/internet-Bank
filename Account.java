package Bank;
import java.util.ArrayList;
import java.util.UUID;


public class Account {
    private UUID serial = UUID.randomUUID();
    private String id;
    private String firstName;
    private String lastName;
    private String type;
    private int balance;
    private ArrayList<transaction> transactions;


    public Account(String firstName, String lastName, String id, String type, int balance){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
        this.type=type;
        this.balance=balance;
        transactions = new ArrayList<transaction>();
    }



    public String getSerial() {
        return serial.toString();

    }

    public String getId() {
        return id;
    }
    public String getUserName(){
        return ""+ firstName + lastName;

    }

    public int getBalance() {
        return balance;

    }

    public String getType() {
        return type;

    }

    public int setBalanceDrawal(int amount){
        int check = 0;
        if (balance + amount > 0){
            balance = balance + amount;
            check = 1;
            System.out.println("completed.\n");
        }
        else {
            System.out.println("Not enough money.\n");
            check = -1;
        }
        return check;
    }

    public void addTransaction(int amount){
        transaction trans = new transaction(amount);
        transactions.add(trans);
    }

    public void setDepositeBalance(int amount){
        balance = balance + amount;

    }

    public void setTransferBalance(int amount){
        balance = balance + amount;

    }

    public void printTransactions(){
        for (transaction transaction: transactions){
            transaction.print();
        }
    }

    public void printAccountData(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(type);
        System.out.println(serial.toString());
        System.out.println(id);
        System.out.println(balance);
    }
}
