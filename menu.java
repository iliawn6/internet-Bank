package Bank;
import java.util.*;

public class menu {
    public static void printMenu(){
        System.out.println("1.Sign up");
        System.out.println("2.Log in");
        System.out.println("3.System Admin");
        System.out.println("4.Exit\n");
    }



    public static void Signup(BankingSystem manager){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\t1.Enter info\n");
            System.out.println("\t2.back\n");
            int input = sc.nextInt();

            if (input == 1){
                //System.out.print("\t\tchert:");
                String firstText = sc.nextLine();
                //System.out.printf("\n");
                System.out.println("\t\tEnter firstName:");
                String firstName = sc.nextLine();
                //System.out.println(firstName);
                System.out.println("\t\tlast name:");
                String lastText = sc.nextLine();
                //System.out.println(lastText);
                /*
                String thirdstr = sc.nextLine();
                System.out.println("Good, first is : " + firstText);
                System.out.println("And second is : " + lastText);
                System.out.println("And third is : " + thirdstr);
                //System.out.printf("\n");

                 */


                //TODO voroodi gereftane firstname va lastname eshkal dare

                System.out.println("\t\tID:");
                String strid = sc.nextLine();
                //System.out.printf("\n");
                //System.out.println(strid);

                System.out.println("\t\tpassword:");
                String strpass = sc.nextLine();
                //System.out.printf("\n");
                //System.out.println(strpass);

                User check = new User(firstName,lastText,strid,strpass);
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
                System.out.println("wrong input.\n\n");
            }

        }


    }



    public static void LoginMenu(BankingSystem manager){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("\t1.Enter user ID and password\n");
            System.out.println("\t2.Back\n\n");
            int input = sc.nextInt();
            if (input == 1){
                //System.out.println("chert");
                String charand = sc.nextLine();
                System.out.println("\t\tuser id:\n");
                String userId = sc.nextLine();
                //System.out.println(userId);
                System.out.println("\t\tpassword:\n");
                String userpass = sc.nextLine();
                //System.out.println(userpass);

                if (manager.login(userId,userpass) == 1){
                    User create = manager.setUser(userId,userpass);
                    //TODO
                    System.out.println("Logged in.\n\n");

                    while (true){
                        System.out.println("1.Existing accounts");
                        System.out.println("2.Add new account");
                        System.out.println("3.Log out\n\n");
                        input = sc.nextInt();
                        if (input == 1){
                            System.out.println("\tchoose from list of accounts:\n");
                            int check = create.printAllAvailableAccounts();
                            if (check == 1){
                                System.out.println("\tnone\n");
                            }
                            else {
                                Account account;
                                while (true){
                                    input = sc.nextInt();
                                    if (input > create.getAccountsListSize() || input <= 0){
                                        System.out.println("wrong input.\n");
                                    }
                                    else {
                                        account = create.getAccount(input-1);
                                        System.out.println("Logged into account.\n\n");
                                        break;
                                    }
                                }
                                transactionMenu(create,manager,account);


                            }
                        }
                        else if (input == 2){
                            charand = sc.nextLine();
                            System.out.println("\tEnter user id:\n");
                            String stId = sc.nextLine();
                            System.out.println("\tEnter account type:\n");
                            String stType = sc.nextLine();
                            if (stId.equals(create.getId())){
                                System.out.println("\tEnter initial amount of account:\n");
                                input = sc.nextInt();
                                Account addAcc = new Account(create.getFirstName(), create.getLastName(),stId,stType,input);
                                create.addAccount(addAcc);
                                manager.addAccount(addAcc);
                                System.out.println("completed.\n");
                            }
                            else {
                                System.out.println("wrong Id.\n");
                            }



                        }
                        else if (input == 3){
                            System.out.println("Logged out of user\n");
                            break;
                        }
                        else {
                            System.out.println("wrong input.\n");
                        }
                    }
                }
                else {
                    System.out.println("user doesn't exists or password is incorrect.\n");
                }


            }
            else if (input == 2){
                break;
            }
            else {
                System.out.println("wrong input.\n");
            }
        }


    }
    public static void transactionMenu(User user,BankingSystem manager ,Account account){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1.Withdrawal");
            System.out.println("2.Deposite");
            System.out.println("3.Transfer");
            System.out.println("4.check balance");
            System.out.println("5.back\n");

            int input = sc.nextInt();
            if (input == 1){
                System.out.println("Enter amount of withdrawal:");
                input = sc.nextInt();
                user.withDrawal(account,input);
                //manager.setacc(account);
            }
            else if (input == 2){
                System.out.println("Enter amount of deposite:");
                input = sc.nextInt();
                user.deposite(account,input);
                //manager.setacc(account);
            }
            //TODO mablaghe har account to userlist va accounts update beshan
            else if (input == 3){
                String chert = sc.nextLine();
                System.out.println("Enter destination account serial:");
                String dest = sc.nextLine();
                System.out.println("Enter amount of transfer:");
                input = sc.nextInt();
                if (manager.findAccount(dest) != null && account.getBalance() >= input){
                    user.transfer(account,manager.findAccount(dest),input);
                    System.out.println("completed.\n");
                }
                else {
                    System.out.println("Destination account doesn’t exist or there is not enough money\n" +
                            "in your account\n");
                }
            }
            else if (input == 4){
                System.out.println(user.checkBalance(account));
            }
            else if (input == 5){
                System.out.println("Logged out of account.\n");
                break;
            }
            else {
                System.out.println("wrong input\n");
            }
        }

    }


    public static void SystemAdmin(BankingSystem manager){
        Scanner sc = new Scanner(System.in);
        //String chert = sc.nextLine();
        System.out.println("Enter username:\n");
        String input1 = sc.nextLine();
        System.out.println("Enter password\n");
        String input2 = sc.nextLine();
        if (input1.equals("sysadmin") && input2.equals("1234")) {
            System.out.println("Logged in as sysadmin.\n\n");
            int checkInt;
            String checkSt;
            while (true){
                System.out.println("1.display users");
                System.out.println("2.display accounts");
                System.out.println("3.remove user");
                System.out.println("4.remove account");
                System.out.println("5.Log out\n");

                int input = sc.nextInt();
                if (input == 1){
                    manager.displayUsers();
                }
                else if (input == 2){
                    manager.displayAccounts();

                }
                else if (input == 3){
                    //TODO moshkel dare
                    System.out.println("Enter user id:\n");
                    String remove = sc.nextLine();
                    checkSt = sc.nextLine();
                    checkInt = manager.removeUser(checkSt);
                    if (checkInt == 1){
                        System.out.println("User removed.\n");
                    }
                    else {
                        System.out.println("User doesn’t exist.\n");
                    }


                }
                else if (input == 4){
                    //TODO moshkel dare
                    System.out.println("Enter account serial :");
                    String remove = sc.nextLine();
                    checkSt = sc.nextLine();
                    checkInt = manager.removeAccount(checkSt);
                    if (checkInt == 1){
                        System.out.println("Account removed.\n");
                    }
                    else {
                        System.out.println("Account doesn’t exist.\n");
                    }
                }
                else if (input == 5){
                    System.out.println("Logged out.\n ");
                    break;

                }
                else {
                    System.out.println("wrong input\n");
                }



            }
        }
        else {
            System.out.println("wrong input.\n");
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
                LoginMenu(manager);
            }
            else if (input == 3){
                SystemAdmin(manager);
            }
            else if (input == 4){
                break;
            }
        }


    }
}
