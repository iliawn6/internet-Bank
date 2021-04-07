package Bank;
import java.util.*;


public class BankingSystem {
    private ArrayList<User> users;
    private ArrayList<Account> accounts;



    public BankingSystem(){
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
    }




    public void register(User user) {
        users.add(user);
    }

    public int checkUser(User user) {
        for (User check : users) {
            if (check.getFirstName().equals(user.getFirstName()) && check.getLastName().equals(user.getLastName())) {
                return -1;
            } else if (check.getId().equals(user.getId())) {
                return -2;
            }
        }
        return 1;
    }

    public int login(String id,String password){
        for (User check: users){
            if (check.getId().equals(id)){
                if (check.getPassword().equals(password)){
                    return 1;
                }
            }
        }
        return -1;
    }

    public User setUser(String id,String password){
        for (User check: users){
            if (check.getId().equals(id)){
                if (check.getPassword().equals(password)){
                    return check;
                }
            }
        }
        User exam = new User("f","l","i","p");
        return exam;
    }

    public Account findAccount(String serial){
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()){
            Account account = it.next();
            if (account.getSerial().equals(serial)){
                return account;
            }
        }
        return null;
    }

    public void addAccount(Account account){
        accounts.add(account);

    }

    public void removeAccount(Account account){
        accounts.remove(account);

    }

    public void displayUsers(){
        int i = 1;
        for (User dis: users){
            System.out.println("user" + i + ":" + dis.getFirstName() + "," + dis.getLastName() + "," + dis.getId());
            i = i + 1;
        }
        System.out.println("\n");
    }

    public void displayAccounts(){
        int i = 1;
        for (Account acc: accounts){
            System.out.println("Account" + i + ":" + acc.getSerial() + "," + acc.getType() + "," + acc.getBalance());
            i = i + 1;
        }
        System.out.println("\n");
    }

    public int removeUser(String userId){
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            User check = it.next();
            if (check.getId().equals(userId)){
                users.remove(check);
                return 1;
            }
        }
        return -1;
    }

    public int removeAccount(String accSerial){
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()){
            Account check = it.next();
            if (check.getSerial().equals(accSerial)){
                accounts.remove(check);
                return 1;
            }
        }
        return -1;
    }

}
