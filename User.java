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
    public void printAllAvailableAccounts(){
        int i=1;
        for (Account account: accountlist){
            System.out.println("Accont" + i + ":" + account.getSerial() + "," +
                    account.getId() + "," + account.getUserName() +
                    "," + account.getBalance());
            i = i + 1;
        }
    }
    public Account getAccount(int index){
        return accountlist.get(index);
    }
    public int getAccountsListSize(){
        return accountlist.size();
    }

    private void setaccountslist(Account account){
        Iterator<Account> it = accountlist.iterator();
        while (it.hasNext()){
            Account check = it.next();
            if (account.getSerial().equals(check.getSerial())){
                check = account;
            }
        }
    }
    //TODO in jaro shayad eshtebah karde bashi

    public void withDrawal(Account account,int amount){
        int check;
         check = account.setBalanceDrawal(-(amount));
         if (check == 1){
             account.addTransaction(-(amount));
            // setaccountslist(account);
         }
    }
    public void deposite(Account account,int amount){
        account.setDepositeBalance(amount);
        account.addTransaction(amount);
        //setaccountslist(account);
        System.out.println("complete");

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
}


