package Bank;
import java.util.*;

public class menu {
    public static void printMenu(){
        System.out.println("1.Sign up");
        System.out.println("2.Log in");
        System.out.println("3.System Admin");
        System.out.println("4.Exit");
    }



    public static void Signup(BankingSystem manager){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\t1.Enter info\n");
            System.out.println("\t2.back\n");
            int input = sc.nextInt();

            if (input == 1){
                System.out.println("\t\tfirstname:");
                String strfirst = sc.nextLine();
                //System.out.printf("\n");

                System.out.println("\t\tlasttname:");
                String strlast = sc.nextLine();
                //System.out.printf("\n");


                //TODO voroodi gereftane firstname va lastname eshkal dare

                System.out.println("\t\tID:");
                String strid = sc.nextLine();
                //System.out.printf("\n");

                System.out.println("\t\tpassword:");
                String strpass = sc.nextLine();
                //System.out.printf("\n");

                User check = new User(strfirst,strlast,strid,strpass);
                if (manager.checkUser(check) == -1){
                    System.out.println("this username is already exist.\n");
                }
                else if (manager.checkUser(check) == -2){
                    System.out.println("this ID has been used before.\n");
                }
                else {
                    System.out.println("user created.\n\n");
                    manager.register(check);
                    break;
                }
            }
            else if (input == 2){
                break;
            }
            else {
                System.out.println("wrong input.");
                break;
            }

        }


    }



    public static void LoginMenu(BankingSystem manager){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\t1.Enter user ID and password");
            System.out.println("\t2.Back");
            int input = sc.nextInt();
            if (input == 1){
                System.out.println("\t\tuser id:");
                String userId = sc.nextLine();
                System.out.println("\t\tpassword:");
                String userpass = sc.nextLine();

                if (manager.login(userId,userpass) == 1){
                    User create = manager.setUser(userId,userpass);
                    System.out.println("Logged in.\n\n");
                    System.out.println("1.Existing accounts");
                    System.out.println("2.Add new account");
                    System.out.println("3.Log out");
                    input = sc.nextInt();
                    if (input == 1){
                        System.out.println("choose from list of accounts:");
                        create.printAllAvailableAccounts();
                        Account account;
                        while (true){
                            input = sc.nextInt();
                            if (input > create.getAccountsListSize() || input <= 0){
                                System.out.println("wrong input.");
                            }
                            else {
                                account = create.getAccount(input-1);
                                System.out.println("Logged into account.");
                                break;
                            }
                        }


                    }
                    else if (input == 2){

                    }
                    else if (input == 3){
                        break;
                    }
                    else {
                        System.out.println("wrong input.");
                        break;
                    }
                }
                else {
                    System.out.println("user doesn't exists or password is incorrect.");
                }


            }
            else if (input == 2){
                break;
            }
            else {
                System.out.println("wrong input");
                break;
            }
        }


    }
    public static void transactionMenu(User user,BankingSystem manager ,Account account){
        System.out.println("1.Withdrawal");
        System.out.println("2.Deposite");
        System.out.println("3.Transfer");
        System.out.println("4.check balance");
        System.out.println("5.back");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1){
            System.out.println("Enter amount of withdrawal:");
            input = sc.nextInt();
            user.withDrawal(account,input);
        }
        else if (input == 2){
            System.out.println("Enter amount of deposite:");
            input = sc.nextInt();
            user.deposite(account,input);
            manager.setacc(account);
        }
        //TODO mablaghe har account to userlist va accounts update beshan
        else if (input == 3){
            System.out.println("Enter destination account serial number:");
            String dest = sc.nextLine();
            System.out.println("Enter amount of transfer:");
            input = sc.nextInt();
        }
        else if (input == 4){

        }
        else if (input == 5){

        }
        else {
            System.out.println("wrong input");
        }
    }





    public static void main(String[] arg){
        BankingSystem manager = new BankingSystem();
        Scanner scan = new Scanner(System.in);
        while (true){
            printMenu();

            int input = scan.nextInt();
            if (input == 1){
                Signup(manager);
            }
            else if (input == 2){

            }
            else if (input == 3){

            }
            else if (input == 4){
                break;
            }
        }



    }
}
