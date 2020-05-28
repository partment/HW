import java.util.Scanner;

public class OrderManagement extends Database {
	private Scanner input = new Scanner(System.in);
	public OrderManagement() {};
	public void entrance() {
		System.out.print("Please enter your membership id : ");
		String id = input.next();
        if(isIDexists(id)) {
            boolean exit = false;
            while(!exit) {
                System.out.println("Please choose what you want to do.");
                System.out.println("(1) List order from you");
                System.out.println("(2) List all order");
                System.out.println("(3) Exit");
                switch(this.input.next()) {
                    case "1":
                    	printOrderbyMember(id);
                        break;
                    case "2":
                    	printOrderAll();
                        break;
                    case "3":
                    	exit = true;
                        break;
                    default:
                        System.out.println("Unknown Feature.");
                        break;
                }
            }
        }else {
            System.out.println("Please register first!");
        }
    }
}
