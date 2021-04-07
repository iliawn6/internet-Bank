package Bank;
import java.util.*;

public class User {
    private String firstName;
    private String lastName;
    private final String id;
    private String password;
    private ArrayList<Account> accountlist;



    public User(String firstName, String lastName, String id, String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
        this.password=password;
        this.accountlist = new ArrayList<Account>();
    }




    public String getFirstName() {
        return firstName;

    }

    public String getLastName(){
        return lastName;

    }

    public String getId(){
        return id;

    }

    public String getPassword(){
        return password;

    }

    public int printAllAvailableAccounts(){
        int i=1;
        for (Account account: accountlist){
            System.out.println("\tAccont" + i + ":" + account.getSerial() + "," +
                    account.getId() + "," + account.getUserName() +
                    "," + account.getBalance() + "\n");
            i = i + 1;
        }
        return i;
    }

    public Account getAccount(int index){
        return accountlist.get(index);

    }

    public int getAccountsListSize(){
        return accountlist.size();

    }

    public void addAccount(Account account){
        accountlist.add(account);

    }

    public void removeaccount(Account account){
        accountlist.remove(account);

    }

    public void withDrawal(Account account,int amount){
        int check;
         check = account.setBalanceDrawal(-(amount));
         if (check == 1){
             account.addTransaction(-(amount));
         }
    }

    public void deposite(Account account,int amount){
        account.setDepositeBalance(amount);
        account.addTransaction(amount);
        System.out.println("completed.");

    }

    public void transfer(Account srcAccount,Account destAccount,int amount){
        srcAccount.setTransferBalance(-(amount));
        destAccount.setTransferBalance(amount);
        srcAccount.addTransaction(-(amount));
        destAccount.addTransaction(amount);
    }

    public int checkBalance(Account account){
        return account.getBalance();

    }

    public void printUserData(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(id);
    }
}


