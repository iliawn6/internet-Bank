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
        //int ret=0;
        for (User check : users) {
            if (check.getFirstName().equals(user.getFirstName()) && check.getLastName().equals(user.getLastName())) {
                System.out.println("this username is already exist");
                return -1;
            } else if (check.getId().equals(user.getId())) {
                System.out.println("this ID has been used before");
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
    public void setacc(Account account){
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()){
            Account check = it.next();
            if (account.getSerial().equals(check.getSerial())){
                check = account;
            }
        }
    }
    //TODO injaram check kon

}
