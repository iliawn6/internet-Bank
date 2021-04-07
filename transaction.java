package Bank;
import java.util.*;


public final class transaction{
    private final int amount;
    private final Date date;


    public transaction(int amount){
        this.amount = amount;
        date = new Date();
    }


    public void print(){
        if (amount > 0){
            System.out.println("+"+amount);
            System.out.println(date.toString());
        }
        else {
            System.out.println(amount);
            System.out.println(date.toString());
        }
    }

}
