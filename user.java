package Bank;
import java.util.*;
public class user {
    private String firstName;
    private String lastName;
    private final int id;
    private String password;
    private ArrayList<Account> accountlist;


    public user(String firstName,String lastName,int id,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
        this.password=password;
    }
}


