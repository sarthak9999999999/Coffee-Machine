import java.util.InputMismatchException;
import java.util.Scanner;
class Coffee_Machine {
    private double water, milk, cbean;
    private int disposal;
    int choice;
    double cost;
    int token_no = 1;
    boolean valid = false;
    public char exit_on_startup;

    public Coffee_Machine() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("======WELCOME TO DELIGHT COFFEE SHOP======\n");
            System.out.println("Fill up the machine Administrator\n Or exit by pressing Q\n");
            exit_on_startup=sc.next().charAt(0);
            if(exit_on_startup=='Q')
            {
                System.exit(0);
            }
            else {
                System.out.print("1.Quantity of Water in the machine(in litres) : ");
                water = sc.nextInt();
                System.out.print("2.Quantity of milk in the machine(in litres) : ");
                milk = sc.nextInt();
                System.out.print("3.Amount of Coffee Beans(in grams) : ");
                cbean = sc.nextInt();
                System.out.println("\n");
                disposal = 20;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter the quantities in Integer form\n");
            e.printStackTrace();
        }
    }

    public void buy() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (remaining() == true) {
                System.out.println("What do You want \n1-ESPRESSO\n2-DOUBLE ESPRESSO\n3-LATTE\n4-CAPPUCCINO");
                choice = sc.nextInt();
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                    System.out.println("Wrong Choice");
                    break;
                }
                make();
                take();
            } else {
                System.out.println("Sorry!! We do not have enough stuff to make a coffee for you\n");
                break;
            }
            System.out.println("Do You Want Another Coffee?[YES/NO]");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("YES")) {
                System.out.println("PLEASE WAIT");
            } else {
                System.out.println("Exiting");
                break;
            }
        }
    }

    Thread t = new Thread();

    public void take() {
        try {
            if (valid) {
                System.out.println("Preparing Your Coffee Please Wait!!\n");
                if (choice == 1 || choice == 2) {
                    Thread.sleep(3000);
                } else if (choice == 3 || choice == 4) {
                    Thread.sleep(4000);
                }
                System.out.println("Your Coffee is ready!!! Collect it!!\n Thank You!!\n");
            } else {
                System.out.println("Please Buy a Valid Token\n");
            }
        } catch (InterruptedException e) {
            System.out.println("I was interrupted!");
            e.printStackTrace();
        }
    }

    public void make() {
        Scanner sc = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("Your Espresso Costs Rs.50\nKindly insert token no.\n");
            int n = sc.nextInt();
            if (n == token_no) {
                water = water - 194;
                milk = milk - 97;
                cbean = cbean - 8;
                disposal--;
                token_no++;
                valid = true;
            } else {
                System.out.println("Wrong Token Number\n");
                valid = false;
            }
        } else if (choice == 2) {
            System.out.println("Your Double Espresso Costs Rs.100\nKindly insert token no.\n");
            int n = sc.nextInt();
            if (n == token_no) {
                water = water - 180;
                milk = milk - 95;
                cbean = cbean - 15;
                disposal--;
                token_no++;
                valid = true;
            } else {
                System.out.println("Wrong Token Number\n");
                valid = false;
            }
        } else if (choice == 3) {
            System.out.println("Your LATTE Costs Rs.30\nKindly insert token no.\n");
            int n = sc.nextInt();
            if (n == token_no) {
                water = water - 199.4;
                milk = milk - 99.7;
                cbean = cbean - 0.9;
                disposal--;
                token_no++;
                valid = true;
            } else {
                System.out.println("Wrong Token Number\n");
                valid = false;
            }
        } else {
            System.out.println("Your Espresso CAPPUCCINO Rs.150\nKindly insert token no.\n");
            int n = sc.nextInt();
            if (n == token_no) {
                water = water - 100;
                milk = milk - 50;
                cbean = cbean - 150;
                disposal--;
                token_no++;
                valid = true;
            } else {
                System.out.println("Wrong Token Number\n");
                valid = false;
            }
        }
    }

    public boolean remaining() {
        if (water == 0 || milk == 0 || cbean == 0 || disposal == 0) {
            return false;
        } else {
            return true;
        }
    }
}
