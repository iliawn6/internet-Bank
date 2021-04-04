package Bank;
import java.util.ArrayList;
import java.util.UUID;
public class Account {
    private UUID serial;
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


}
