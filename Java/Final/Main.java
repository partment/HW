import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("Welcome to Good Life Foods, please choose what you want to do.");
            System.out.println("(1) Place an order");
            System.out.println("(2) Register");
            System.out.println("(3) Order Management");
            System.out.println("(4) Exit");
            switch(input.next()) {
                case "1":
                    System.out.print("Please enter your membership id : ");
                    Order order = new Order(input.next());
                    break;
                case "2":
                    Register register = new Register();
                    break;
                case "3":
                    System.out.print("Please enter your membership id : ");
                    //OrderManagement order = new OrderManagement(input.next());
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown Feature.");
                    break;
            }
        }
    }
}