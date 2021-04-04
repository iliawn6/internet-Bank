package Bank;
import java.util.*;

public class menu {
    public static void printMenu(){
        System.out.println("1.Sign up");
        System.out.println("2.Log in");
        System.out.println("3.System Admin");
        System.out.println("4.Exit");
    }


    public static void Signup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t1.Enter info\n");
        System.out.println("\t2.back\n");

        System.out.printf("\t\tfirstname:");
        String strfirst = sc.nextLine();
        System.out.printf("\n");

        System.out.printf("\t\tlasttname:");
        String strlast = sc.nextLine();
        System.out.printf("\n");

        System.out.printf("\t\tID:");
        String strid = sc.nextLine();
        System.out.printf("\n");

        System.out.printf("\t\tpassword:");
        String strpass = sc.nextLine();
        System.out.printf("\n");

    }


    public static void main(String[] arg){
        printMenu();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1){

        }
        else if (input == 2){

        }
        else if (input == 3){

        }
        else if (input == 4){

        }


    }
}
